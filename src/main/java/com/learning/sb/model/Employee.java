package com.learning.sb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    String name;
    String department;

    public Employee(String name) {
        this.name = name;
    }
}
