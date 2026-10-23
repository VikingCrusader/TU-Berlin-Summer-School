package com.example.book.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.resources.Topic;

// 课件第 58-62、75-110 页：Topic 的 CRUD REST 接口
@RestController
public class TopicController {

    @Autowired
    private TopicsService topicsService;

    // GET /topics
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicsService.getAllTopics();
    }

    // GET /topics/{id}
    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicsService.getTopic(id);
    }

    // GET /topics/search?name=...（课件第 142 页 findByName）
    @RequestMapping("/topics/search")
    public List<Topic> getTopicsByName(@RequestParam String name) {
        return topicsService.getTopicsByName(name);
    }

    // POST /topics
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicsService.addTopic(topic);
    }

    // PUT /topics/{id}
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicsService.changeTopic(topic, id);
    }

    // DELETE /topics/{id}
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicsService.deleteTopic(id);
    }
}
