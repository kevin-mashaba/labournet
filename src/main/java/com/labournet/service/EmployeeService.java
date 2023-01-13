package com.labournet.service;

import java.util.List;

import com.labournet.dto.EmployeeDTO;
import com.labournet.entity.Employee;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws Exception;
	
	EmployeeDTO findEmployeeByEmpNo(String empNo);
	
	EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO deleteEmployee(String empNo);

	List<EmployeeDTO> findAllEmployees();
}
