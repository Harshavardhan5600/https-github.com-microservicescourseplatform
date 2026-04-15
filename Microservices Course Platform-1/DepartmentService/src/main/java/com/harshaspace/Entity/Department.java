package com.harshaspace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentid;
	
	private String departmentname;
	
	private String departmentwork;
	
	private String departmentcode;
	
	public long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentwork() {
		return departmentwork;
	}

	public void setDepartmentwork(String departmentwork) {
		this.departmentwork = departmentwork;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	
	

}
