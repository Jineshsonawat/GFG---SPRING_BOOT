package com.learning.sb.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.sb.config.GoogleDrive;
import com.learning.sb.ex.Food;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.List;

// this annotation marked this class as bean.

@Component
public class TestService {

//    ObjectMapper is an external dependency in world of java used to convert JSON into java object and vice versa
    private final ObjectMapper objectMapper = new ObjectMapper();

//    We do not mark the class with @Component still using as Bean bcz we marked as @Bean.
    public GoogleDrive googleDrive;

    public TestService(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    public Food getFoodById(int id) throws IOException {
        List<Food> foodList = this.objectMapper.readValue(
                new File("src/food.json"),
                new TypeReference<>() {}
        );

        Food food = foodList.stream()
                .filter(it -> it.getId() == id)
                .toList()
                .get(0);

        return food;
    }

    public void sayHello(){
        this.googleDrive.upload(new File("/About SpringBoot"));
        System.out.println("Hello World");
    }
}
