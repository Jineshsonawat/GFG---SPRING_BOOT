package com.learning.sb.entity;

import jakarta.persistence.*;
import lombok.*;

// If we do not provide the name of the table it will create one.

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //    We can provie default values as name = "Jinesh"
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity ;


}
