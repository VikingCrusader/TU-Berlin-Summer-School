# Book Topics Service (Lecture 15 Class Project)

A REST service for book topics, built on Spring Boot 3.5. This is the **final version** of the code from the lecture slides: a three-layer Controller → Service → Repository design, with persistence through Spring Data JPA.

## Project Structure

```
src/main/java/com/example/book/
├── ExampleApiApp.java            Entry point, @SpringBootApplication          (slides p45-46)
├── hello/HelloController.java    First endpoint, /hello                       (p50-53)
├── resources/Topic.java          Entity class, @Entity → topic table          (p56-57, 121-123)
├── repository/UserRepository.java Data access, extends JpaRepository          (p125-126, 142)
└── topic/
    ├── TopicsService.java        Business layer, @Service                     (p77-106, 140-141)
    └── TopicController.java      CRUD REST endpoints, @RestController         (p58-110)
src/main/resources/
├── application.properties        Default config (embedded H2 database)        (p69-71, 120)
├── application-mysql.properties  MySQL config from the slides
└── static/                       index.html, topics.html (reads JSON via fetch) (p54, 63-67)
```

## Endpoints

| Method | URL | Description |
|---|---|---|
| GET | `/topics` | Get all topics |
| GET | `/topics/{id}` | Get a topic by id |
| GET | `/topics/search?name=xxx` | Find topics by name (findByName) |
| POST | `/topics` | Create a topic (JSON request body) |
| PUT | `/topics/{id}` | Update a topic |
| DELETE | `/topics/{id}` | Delete a topic |

## Running

Requires JDK 17 or later and Maven.

```bash
mvn spring-boot:run                     # Run in development
mvn clean install                       # Build the package (slides p145)
java -jar target/demo-0.0.1-SNAPSHOT.jar  # Run standalone (slides p147)
java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=mysql  # Use MySQL instead
```

The database starts out empty (matching slide p130). You can add some data first:

```bash
curl -X POST localhost:8080/topics -H "Content-Type: application/json" -d '{"id":"11236Y","name":"Harry Potter","description":"Fantasy book"}'
curl -X POST localhost:8080/topics -H "Content-Type: application/json" -d '{"id":"55625C","name":"Star Wars","description":"SCFI story"}'
```

Then open:

- http://localhost:8080/topics.html: the frontend page
- http://localhost:8080/h2-console: the database console. Use JDBC URL `jdbc:h2:file:./data/randdb` and username `sa`

## Evolution (the three stages in the slides)

1. **Hard-coded data in the Controller** (p58-62): `getAllTopics()` simply creates a new List and returns it. Spring automatically converts it to JSON.
2. **Extracting a Service layer with in-memory data** (p76-110): `TopicsService` stores data in a `List<Topic>` and is injected into the Controller via `@Autowired` to implement CRUD. Data is lost on restart.
3. **Connecting a database** (p113-142): the List is replaced with `UserRepository`, and `findAll` / `findById` / `save` / `deleteById` are all implemented automatically by Spring Data JPA.

## Differences from the Slides (all fixes, no feature changes)

- `Topic` uses `@Entity`. The `@EntityScan` written in the slides does not mark a class as an entity, so the table would never be created.
- The mapping annotations for the POST and DELETE methods were incomplete in the slides, and the POST path was mistakenly written as `/topic`. Both are unified to `/topics` here.
- The slides contain typos, such as `private TopicsService ;` missing a variable name and an extra `@` in `@RequestBody @Topic`. These have been corrected.
- `changeTopic` writes the id from the URL into the entity, so PUT always updates the specified record.
- The parent POM version is `3.5.4`. Since Spring Boot 3, version numbers no longer carry the `.RELEASE` suffix.
- The default database is H2, so the project runs without installing MySQL (the slides use embedded Derby for development and testing, which serves the same purpose). The MySQL config is kept in the `mysql` profile, and the password can be passed through the `DB_PASSWORD` environment variable.
- `/hello` returns plain text. Slide p55 uses `return "index.html"` inside a `@RestController`, which only returns the string itself. The static page `index.html` opens directly at `/`.
