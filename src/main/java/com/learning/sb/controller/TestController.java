package com.learning.sb.controller;


import com.learning.sb.Service.TestService;
import com.learning.sb.ex.Food;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TestController {

    private final TestService testService;

//    Constructor Injection
    public TestController(TestService testService) {
        this.testService = testService;
    }

    //   It used to get the data whenever the Url is hit.
    @GetMapping("/")
    public void sayHello(){
        this.testService.sayHello();
    }

    @GetMapping("/pizza")
    public String getFood(){
        return "Make Pizza";
    }

    @GetMapping("/food")
    public Food getData(){
        Food f = new Food();
        f.setName("Pizza");
        return f;
    }

//    From this we can post the data. If we use body for taking data then need to use @RequestBody
    @PostMapping("/write")
    public String write(@RequestBody String toWrite){
        try (FileWriter fw = new FileWriter("src/hello.txt", true)) {
            fw.write(toWrite);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return toWrite;
    }
}
