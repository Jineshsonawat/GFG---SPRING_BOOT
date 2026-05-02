package com.learning.sb.repository.impl;

import com.learning.sb.model.EmployeeJPA;
import com.learning.sb.repository.jpa.EmployeeJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final EmployeeJPARepository employeeJPARepository;

    public EmployeeRepository(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

// These function are internally connected to JPA Repository -> Hibernate -> Postgres Driver
// These all methods comes with id bcz it's PK. We can create our own in EmployeeJPARepository

//    These all called as CRUD operation
//    Save is an upsert operation it will create if it does not exist else update it.
//    Create + Update
    public EmployeeJPA saveOrUpdate(EmployeeJPA employee){
        return this.employeeJPARepository.save(employee);
    }

//  READ/RETRIEVE
    public EmployeeJPA getByID(int id){
        return this.employeeJPARepository.findById(id).orElse(null);
    }

//    Delete
    public void deleteByID(int id){
        this.employeeJPARepository.deleteById(id);
    }

    public EmployeeJPA getByName(String name){
        return this.employeeJPARepository.findByName(name).orElse(null);
    }
}
