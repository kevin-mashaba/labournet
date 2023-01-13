package com.labournet.form;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class EmployeeForm {

	private String name;
	private String surname;
	private String empNo;
	
	public EmployeeForm() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeForm(String name, String surname, String empNo) {
		super();
		this.name = name;
		this.surname = surname;
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	
	
}
