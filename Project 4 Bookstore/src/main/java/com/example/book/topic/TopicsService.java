package com.example.book.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.repository.UserRepository;
import com.example.book.resources.Topic;

// 课件第 140-142 页：业务层最终版本，数据存取交给 UserRepository
@Service
public class TopicsService {

    @Autowired
    private UserRepository userRepository;

    // Get all topics
    public List<Topic> getAllTopics() {
        List<Topic> tempList = new ArrayList<>();
        userRepository.findAll().forEach(tempList::add);
        return tempList;
    }

    // Get topic by ID
    public Optional<Topic> getTopic(String id) {
        return userRepository.findById(id);
    }

    // Get topics by name
    public List<Topic> getTopicsByName(String name) {
        return userRepository.findByName(name);
    }

    // Add topic
    public void addTopic(Topic topic) {
        userRepository.save(topic);
    }

    // Remove topic by ID
    public void deleteTopic(String id) {
        userRepository.deleteById(id);
    }

    // Change topic by ID
    public void changeTopic(Topic topic, String id) {
        topic.setId(id);
        userRepository.save(topic);
    }
}
