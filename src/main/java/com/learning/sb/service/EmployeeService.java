package com.learning.sb.service;

import com.learning.sb.entity.EmployeeEntity;
import com.learning.sb.repository.impl.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee){
        return this.employeeRepository.saveOrUpdate(employee);
    }

    public EmployeeEntity getEmployeeById (int id){
        return this.employeeRepository.getByID(id);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee){
        return this.employeeRepository.saveOrUpdate(employee);
    }

    public void deleteEmployeeById (int id){
         this.employeeRepository.deleteByID(id);
    }
}
