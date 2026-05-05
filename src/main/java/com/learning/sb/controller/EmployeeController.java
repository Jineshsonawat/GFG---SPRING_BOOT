package com.learning.sb.controller;

import com.learning.sb.dto.EmployeeDto;
import com.learning.sb.entity.EmployeeEntity;
import com.learning.sb.mapper.dto.EmployeeDtoMapper;
import com.learning.sb.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDtoMapper employeeDtoMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeDtoMapper employeeDtoMapper) {
        this.employeeService = employeeService;
        this.employeeDtoMapper = employeeDtoMapper;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = this.employeeDtoMapper.toEntity(employeeDto);
        EmployeeEntity savedEmployee = this.employeeService.addEmployee(employeeEntity);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        EmployeeEntity employee = this.employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity employee){
        EmployeeEntity updateEmployee = this.employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        this.employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
