package com.springbootapp_1.EmpSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp_1.EmpSystem.entity.Employee;
import com.springbootapp_1.EmpSystem.repository.EmpRepo;

@Service

public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		
		repo.save(e);
		
	} 
	public java.util.List<Employee> getAllEmp (){
		
		return repo.findAll();
	}
	public Employee getEmpById(int id) {
		
		
		return repo.findById(id).get();
	}
	public void deleteEmp(int id) {
		
		 repo.deleteById(id);
	}
}
