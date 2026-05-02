package com.learning.sb.controller;

import com.learning.sb.model.Employee;
import com.learning.sb.model.EmployeeJPA;
import com.learning.sb.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeJPA employee){
        EmployeeJPA savedEmployee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        EmployeeJPA employee = this.employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeJPA employee){
        EmployeeJPA updateEmployee = this.employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        this.employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
