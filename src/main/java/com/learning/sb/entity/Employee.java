package com.learning.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    private int id;
    private String name;
    private String department;

    public Employee(String name) {
        this.name = name;
    }


}
