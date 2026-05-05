package com.learning.sb.repository.jpa;

import com.learning.sb.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//in JpaRepository<Employee, Integer>, First is the entity class which needs as JPA and second in the Data type of PK.
//Nothing else to do here it's created. If we want to modify methods and others then mention here
public interface EmployeeJPARepository extends JpaRepository<EmployeeEntity, Integer> {

    // JPA will automatically create the query as the method name suggests.
// as Optional if it finds the value, provides that else option of null.
// as it only can provide a single valur and which value it finds first provides that.
// else use List
    Optional<EmployeeEntity> findByName(String name);

    //    Need the name as we want but want to behave as finding value with name
//    Annotate with this and provide the query
//    @Query("Select e from employee e where e.name = ?1")
//    Optional<EmployeeJPA> testFunction(String name);
}
