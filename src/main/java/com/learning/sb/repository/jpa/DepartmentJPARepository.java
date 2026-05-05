package com.learning.sb.repository.jpa;

import com.learning.sb.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJPARepository extends JpaRepository<DepartmentEntity,Integer> {
}
