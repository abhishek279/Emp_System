package com.springbootapp_1.EmpSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootapp_1.EmpSystem.entity.Employee;
import com.springbootapp_1.EmpSystem.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model model) {
		
		List<Employee> emp =service.getAllEmp();
		model.addAttribute("emp", emp);
		
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {

		System.out.println(e);
		service.addEmp(e);
		
		session.setAttribute("msg", "Employee Added Successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model model) {
		
		Employee e = service.getEmpById(id);
		model.addAttribute("emp",e); 
		return "edit";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e,HttpSession session ) {
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Updated successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model model) {
		
		Employee e = service.getEmpById(id);
		model.addAttribute("emp",e);
		service.deleteEmp(id);
		return "redirect:/";
	}
	

	
}
