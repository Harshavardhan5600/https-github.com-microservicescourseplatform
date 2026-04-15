package com.harshaspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshaspace.Entity.Department;
import com.harshaspace.Service.departmentservice;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private departmentservice departmentService;
	
	@PostMapping("/save")
	public Department savedepartment(@RequestBody Department department) {
		return departmentService.savedepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentbyId(@PathVariable Long id) {
		return departmentService.getbydepartmentid(id);
	}

}
