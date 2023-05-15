package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Department;

public interface DepartmentRepository_jpa extends JpaRepository<Department, Long>{
  
}
