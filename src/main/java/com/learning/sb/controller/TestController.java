package com.learning.sb.controller;


import com.learning.sb.Exception.NotFoundException;
import com.learning.sb.model.Employee;
import com.learning.sb.service.TestService;
import com.learning.sb.model.ErrorResponse;
import com.learning.sb.model.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        this.testService.test();
    }


    @GetMapping("/pizza")
    public String getFood(){
        return "Make Pizza";
    }

    /*If we read a JSON file having id and want to get the data from id. Two ways
      1. Path Params = @PathVariable -> need to add id in the URL
      2. Query Params = @RequestParam -> No need to add in URL.
         change PathVariable to RequestParam and try using postman.
         */
    @GetMapping("/get_item/{id}")
    public ResponseEntity<?> makePizza(@PathVariable int id) throws IOException {
        try{
            Food food =  this.testService.getFoodById(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        }catch(NotFoundException e){
            return new ResponseEntity<>(ErrorResponse.builder()
                    .message(e.getMessage())
                    .build(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/employee_list")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> e = this.testService.addAllEmployee();

        return new ResponseEntity<>(e, HttpStatus.OK);
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
