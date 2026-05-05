package com.learning.sb.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.sb.Exception.NotFoundException;
import com.learning.sb.config.GoogleDrive;
import com.learning.sb.mapper.EmployeeRowMapper;
import com.learning.sb.entity.Employee;
import com.learning.sb.entity.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// this annotation marked this class as bean.
@Slf4j
@Service
public class TestService {

//    Can be done by the annotation @Slf4j
//    private static Logger log = LoggerFactory.getLogger(TestService.class);

//    ObjectMapper is an external dependency in world of java used to convert JSON into java object and vice versa
    private final ObjectMapper objectMapper = new ObjectMapper();

//    We do not mark the class with @Component still using as Bean bcz we marked as @Bean.
    public GoogleDrive googleDrive;

    private JdbcTemplate jdbcTemplate;

    public TestService(GoogleDrive googleDrive, JdbcTemplate jdbcTemplate) {
        this.googleDrive = googleDrive;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Food getFoodById(int id) throws IOException {

        List<Food> foodList = this.objectMapper.readValue(
                new File("src/food.json"),
                new TypeReference<>() {}
        );

        List<Food> foodFound = foodList.stream()
                .filter(it -> it.getId() == id)
                .toList();

        if(foodFound.isEmpty()){
            throw new NotFoundException(Food.class, "id", id);
        }

        Food food = foodFound.get(0);

        log.info("Food with id: {} was found", id);

        return food;
    }

    public void sayHello(){
        this.googleDrive.upload(new File("/About SpringBoot"));
        System.out.println("Hello World");
    }

    public void test(){
//        we have to provide values rather we only want to provide name. we have to put id also.
//        Food food = new Food(0, "Jinesh");

//        We do not need to provide id.
        Food food = Food.builder()
                .name("Jinesh")
                .build();
//        If we want to change the name only
           food.setName("Aman");

//        If you need a copy of whole object with different name
        Food food1 = food.withName("Aman");

    }

    public List<Employee> addAllEmployee(){
        List<Employee> list = new ArrayList<Employee>();
        String fetch = "Select * from public.employee";

//        This line return a list of employee and internally call rowMapper.mapRow()
        return this.jdbcTemplate.query(fetch , new EmployeeRowMapper());
    }

}

