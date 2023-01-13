package com.labournet.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.labournet.dto.EmployeeDTO;
import com.labournet.service.EmployeeService;

@Component
@RequestScope
public class EmployeeFormAction implements Serializable {

	@Autowired
	private EmployeeService employeeService;
	
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  

	
	private final EmployeeForm employeeDTO ;
	

	public EmployeeFormAction(@Autowired EmployeeService employeeService, 
							@Autowired EmployeeForm employeeDTO) {
		this.employeeService = employeeService;
		this.employeeDTO = employeeDTO;
	}


	public List<EmployeeDTO> findAllEmployees() {

		List<EmployeeDTO> employees = employeeService.findAllEmployees();
		return employees;
	}
	
	
	public String save() {
		
		System.out.println("Name " + employeeDTO.getName() + " Surname " + employeeDTO.getSurname()
		+ " Employee number " + employeeDTO.getEmpNo());
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setName(employeeDTO.getName());
		empDTO.setSurmame(employeeDTO.getSurname());
		empDTO.setEmpNo(employeeDTO.getEmpNo());
		
		
		try {
			System.out.println("Saving.. " + employeeDTO.toString());
			employeeService.createEmployee(empDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	public String edit(String empNo) {
		//empId = employeeDTO.getEmpNo();
		EmployeeDTO empDto = employeeService.findEmployeeByEmpNo(empNo);
		
		//employeeService.updateEmployee(empDto);
		
		
		sessionMap.put("updateEmp", empDto);
		
		return "/edit.xhtml?faces-redirect=true";
	}
	
	public String updateUser(String empNo)
	{
		EmployeeDTO empDto = employeeService.findEmployeeByEmpNo(empNo);
		empDto.setName(employeeDTO.getName());
		empDto.setSurmame(employeeDTO.getSurname());
		employeeService.updateEmployee(empDto);
		
		return "";
		
	}
	
	public String delete(String empNo) {
		
		EmployeeDTO empDto = employeeService.findEmployeeByEmpNo(empNo);
		employeeService.deleteEmployee(empNo);
		return "";
	}
	
}
