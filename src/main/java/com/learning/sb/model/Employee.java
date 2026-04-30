package com.learning.sb.model;

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
