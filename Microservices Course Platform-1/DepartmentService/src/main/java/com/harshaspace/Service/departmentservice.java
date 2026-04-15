package com.harshaspace.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshaspace.Entity.Department;
import com.harshaspace.repository.DepartmentRepository;

@Service
public class departmentservice  {
	
	@Autowired
	private DepartmentRepository departmentrepository;
	
	public Department savedepartment(Department department) {
		return departmentrepository.save(department);
	}
	
	public Department getbydepartmentid(Long id) {
		return departmentrepository.findById(id).get();
	}

}
