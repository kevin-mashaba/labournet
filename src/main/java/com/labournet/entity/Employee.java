package com.labournet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "employee_number")
	private String empNo;
	
	@Column(name = "employee_name")
	private String empName;
	
	@Column(name = "employee_surname")
	private String empSurname;

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Employee(String empNo, String empName, String empSurname) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empSurname = empSurname;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}




	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpSurname() {
		return empSurname;
	}


	public void setEmpSurname(String empSurname) {
		this.empSurname = empSurname;
	}
	
	
	
}
