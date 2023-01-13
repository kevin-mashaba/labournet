package com.labournet.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labournet.dto.EmployeeDTO;
import com.labournet.entity.Employee;
import com.labournet.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(path = "/",method = RequestMethod.POST)
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
		
		EmployeeDTO employee = employeeService.createEmployee(employeeDTO);
		
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{empNo}",method = RequestMethod.GET)
	public ResponseEntity<EmployeeDTO> findByEmployeeNumber(@PathVariable("empNo") String empNo) throws Exception{
		
		EmployeeDTO employeeDTO = employeeService.findEmployeeByEmpNo(empNo);
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees(){
		
		List<EmployeeDTO> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{empNo}", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeDTO> updateUser(@PathVariable("empNo") String empNo,@RequestBody EmployeeDTO employeeDTO ) throws Exception{
		employeeDTO.setEmpNo(empNo);
		EmployeeDTO dto = employeeService.updateEmployee(employeeDTO);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{empNo}", method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("empNo") String empNo) throws Exception{
		
		EmployeeDTO employeeDTO = employeeService.findEmployeeByEmpNo(empNo);
		employeeService.deleteEmployee(employeeDTO.getEmpNo());
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
		
	}
}
