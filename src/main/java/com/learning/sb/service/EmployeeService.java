package com.learning.sb.service;

import com.learning.sb.model.EmployeeJPA;
import com.learning.sb.repository.impl.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeJPA addEmployee(EmployeeJPA employee){
        return this.employeeRepository.saveOrUpdate(employee);
    }

    public EmployeeJPA getEmployeeById (int id){
        return this.employeeRepository.getByID(id);
    }

    public EmployeeJPA updateEmployee(EmployeeJPA employee){
        return this.employeeRepository.saveOrUpdate(employee);
    }

    public void deleteEmployeeById (int id){
         this.employeeRepository.deleteByID(id);
    }
}
