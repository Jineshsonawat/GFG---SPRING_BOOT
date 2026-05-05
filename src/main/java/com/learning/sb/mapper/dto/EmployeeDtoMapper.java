package com.learning.sb.mapper.dto;

import com.learning.sb.dto.EmployeeDto;
import com.learning.sb.entity.DepartmentEntity;
import com.learning.sb.entity.EmployeeEntity;
import com.learning.sb.repository.impl.DepartmentRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper {

    private final DepartmentRepository departmentRepository;

    public EmployeeDtoMapper(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public EmployeeEntity toEntity(EmployeeDto employeeDto){
        DepartmentEntity departmentEntity = this.departmentRepository.getById(employeeDto.getDepartmentId());
        return EmployeeEntity.builder()
                .name(employeeDto.getName())
                .departmentEntity(departmentEntity)
                .build();
    }
}
