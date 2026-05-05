package com.learning.sb.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@JsonDeserialize

@Data
public class EmployeeDto {

    private String name;
    private int departmentId;
}
