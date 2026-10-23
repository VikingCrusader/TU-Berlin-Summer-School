package com.example.book.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 课件第 50-53 页：第一个 REST 接口
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String printHi() {
        return "Hello world from web page";
    }
}
