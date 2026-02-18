package com.learning.sb.controller;


import com.learning.sb.Service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public void sayHello(){
        this.testService.sayHello();
    }
}
