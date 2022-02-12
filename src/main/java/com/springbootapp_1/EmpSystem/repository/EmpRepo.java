package com.springbootapp_1.EmpSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp_1.EmpSystem.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
