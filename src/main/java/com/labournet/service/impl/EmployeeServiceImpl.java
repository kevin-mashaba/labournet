package com.labournet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labournet.dto.EmployeeDTO;
import com.labournet.dto.EmployeeMapper;
import com.labournet.entity.Employee;
import com.labournet.exception.EmployeeAlreadyExists;
import com.labournet.exception.ResourceNotFoundException;
import com.labournet.repository.EmployeeRepository;
import com.labournet.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// save employee to database
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws Exception {
		// TODO Auto-generated method stub

		if (employeeDTO == null) {
			throw new Exception("Employee can't be null");
		} else {

			Employee emp = EmployeeMapper.mapToJpa(employeeDTO);

			Optional<Employee> employee = employeeRepository.findByEmpNo(employeeDTO.getEmpNo());
			if (employee.isPresent()) {
				throw new EmployeeAlreadyExists("Employee Already Exists!");
			}

			Employee saveEmployee = employeeRepository.save(emp);

			EmployeeDTO dto = EmployeeMapper.mapToDto(saveEmployee);

			return dto;
		}

	}

	// search for user in database
	@Override
	public EmployeeDTO findEmployeeByEmpNo(String empNo) {
		// TODO Auto-generated method stub

		Employee employee = employeeRepository.findByEmpNo(empNo)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empNo));

		return EmployeeMapper.mapToDto(employee);

	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		return list.stream().map(EmployeeMapper::mapToDto).collect(Collectors.toList());
	}

	// update user
	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub

		Employee employee = employeeRepository.findByEmpNo(employeeDTO.getEmpNo())
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "empNo", employeeDTO.getEmpNo()));

		if (employeeDTO.getName() != null) {
			employee.setEmpName(employeeDTO.getName());
		}

		if (employeeDTO.getSurmame() != null) {
			employee.setEmpSurname(employeeDTO.getSurmame());
		}

		Employee updatedEmp = employeeRepository.save(employee);

		return EmployeeMapper.mapToDto(updatedEmp);
	}

	// delete user
	@Override
	public EmployeeDTO deleteEmployee(String empNo) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findByEmpNo(empNo)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "empNo", empNo));
		employeeRepository.delete(employee);
		return EmployeeMapper.mapToDto(employee);
	}

}
