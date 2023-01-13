package com.labournet.dto;

public class EmployeeDTO {

	private long empId;
	
	private String empNo;
	
	private String name;
	
	private String surmame;

	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeDTO( String empNo, String name, String surmame) {

		this.empNo = empNo;
		this.name = name;
		this.surmame = surmame;
	}


	public long getEmpId() {
		return empId;
	}


	public void setEmpId(long empId) {
		this.empId = empId;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurmame() {
		return surmame;
	}


	public void setSurmame(String surmame) {
		this.surmame = surmame;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empNo=" + empNo + ", name=" + name + ", surmame=" + surmame + "]";
	}
	
	
	
	
}
