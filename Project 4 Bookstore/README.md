# Book Topics 服务（Lecture 15 课堂项目）

基于 Spring Boot 3.5 的图书主题（Topic）REST 服务。这是课件**最终版本**的代码：Controller → Service → Repository 三层，用 Spring Data JPA 持久化。

## 目录结构

```
src/main/java/com/example/book/
├── ExampleApiApp.java            程序入口 @SpringBootApplication        (课件 p45-46)
├── hello/HelloController.java    第一个接口 /hello                       (p50-53)
├── resources/Topic.java          实体类 @Entity → topic 表               (p56-57, 121-123)
├── repository/UserRepository.java 数据访问，继承 JpaRepository            (p125-126, 142)
└── topic/
    ├── TopicsService.java        业务层 @Service                          (p77-106, 140-141)
    └── TopicController.java      CRUD REST 接口 @RestController           (p58-110)
src/main/resources/
├── application.properties        默认配置（H2 嵌入式数据库）              (p69-71, 120)
├── application-mysql.properties  课件里的 MySQL 配置
└── static/                       index.html、topics.html（fetch 读 JSON） (p54, 63-67)
```

## 接口

| 方法 | URL | 作用 |
|---|---|---|
| GET | `/topics` | 查询全部 |
| GET | `/topics/{id}` | 按 id 查询 |
| GET | `/topics/search?name=xxx` | 按名称查询（findByName） |
| POST | `/topics` | 新增（JSON 请求体） |
| PUT | `/topics/{id}` | 修改 |
| DELETE | `/topics/{id}` | 删除 |

## 运行

需要 JDK 17 及以上版本和 Maven。

```bash
mvn spring-boot:run                     # 开发运行
mvn clean install                       # 打包（课件 p145）
java -jar target/demo-0.0.1-SNAPSHOT.jar  # 独立运行（课件 p147）
java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=mysql  # 改用 MySQL
```

启动后数据库是空的（和课件第 130 页一致）。可以先添加几条数据：

```bash
curl -X POST localhost:8080/topics -H "Content-Type: application/json" -d '{"id":"11236Y","name":"Harry Potter","description":"Fantasy book"}'
curl -X POST localhost:8080/topics -H "Content-Type: application/json" -d '{"id":"55625C","name":"Star Wars","description":"SCFI story"}'
```

然后访问：

- http://localhost:8080/topics.html：前端页面
- http://localhost:8080/h2-console：查看数据库，JDBC URL 填 `jdbc:h2:file:./data/randdb`，用户名填 `sa`

## 演进过程（课件里的三个阶段）

1. **Controller 里写死数据**（p58-62）：`getAllTopics()` 直接 new 一个 List 返回。Spring 会自动把它转成 JSON。
2. **抽出 Service 层，数据放在内存**（p76-110）：`TopicsService` 用一个 `List<Topic>` 存数据，通过 `@Autowired` 注入 Controller，实现增删改查。重启后数据会丢失。
3. **接入数据库**（p113-142）：把 List 换成 `UserRepository`，`findAll` / `findById` / `save` / `deleteById` 都由 Spring Data JPA 自动实现。

## 与课件的差异（都是修正，不是功能改动）

- `Topic` 用的是 `@Entity`。课件写的 `@EntityScan` 不能把类标记为实体，表不会被创建。
- 课件里 POST 和 DELETE 方法的映射注解没有补全，POST 路径还误写成 `/topic`。这里统一为 `/topics`。
- 课件里有拼写错误，比如 `private TopicsService ;` 缺少变量名，`@RequestBody @Topic` 多了一个 `@`。这些都已修正。
- `changeTopic` 会把 URL 里的 id 写入实体，保证 PUT 的是指定的那一条记录。
- 父 POM 版本写成 `3.5.4`。Spring Boot 3 起版本号不再带 `.RELEASE` 后缀。
- 默认数据库改用 H2，不需要安装 MySQL 就能运行（课件里开发测试用的是嵌入式的 Derby，作用相同）。MySQL 配置保留在 `mysql` profile 中，密码可以通过 `DB_PASSWORD` 环境变量传入。
- `/hello` 返回的是文本。课件第 55 页在 `@RestController` 里 `return "index.html"`，只会返回字符串本身。静态页面 `index.html` 直接访问 `/` 就能打开。
