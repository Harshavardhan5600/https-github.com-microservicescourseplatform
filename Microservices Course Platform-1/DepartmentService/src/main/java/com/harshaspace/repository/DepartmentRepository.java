package com.harshaspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshaspace.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
