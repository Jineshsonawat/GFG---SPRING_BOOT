package com.learning.sb.repository.impl;

import com.learning.sb.Exception.NotFoundException;
import com.learning.sb.entity.DepartmentEntity;
import com.learning.sb.repository.jpa.DepartmentJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    private final DepartmentJPARepository departmentJPARepository;

    public DepartmentRepository(DepartmentJPARepository departmentJPARepository) {
        this.departmentJPARepository = departmentJPARepository;
    }

    public DepartmentEntity getById(int id){
        return this.departmentJPARepository.findById(id).orElseThrow(() ->
                new NotFoundException(DepartmentEntity.class , "id" , id)
        );
    }
}
