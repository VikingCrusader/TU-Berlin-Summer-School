package com.example.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.resources.Topic;

// 课件第 125-126、142 页：继承 JpaRepository 即获得 CRUD 方法
public interface UserRepository extends JpaRepository<Topic, String> {

    // 按方法名自动生成查询：SELECT * FROM topic WHERE name = ?
    List<Topic> findByName(String name);
}
