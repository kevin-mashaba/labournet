package com.labournet.dto;

import com.labournet.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO mapToDto(Employee employee) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO(
				employee.getEmpNo(),employee.getEmpName(),employee.getEmpSurname());
		return employeeDTO;
	}
	
	public static Employee mapToJpa(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee(
				employeeDTO.getEmpNo(),
				employeeDTO.getName(),
				employeeDTO.getSurmame());
		return employee;
	}
}
