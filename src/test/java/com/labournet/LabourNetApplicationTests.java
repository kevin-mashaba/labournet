package com.labournet;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.labournet.entity.Employee;
import com.labournet.exception.EmployeeAlreadyExists;
import com.labournet.repository.EmployeeRepository;

//@SpringBootTest
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LabourNetApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	@Rollback(value = false)
	public void createEmployeeTest() {

		Employee employee = new Employee("LB444", "Kevin", "Mashaba");

		Optional<Employee> e = employeeRepository.findByEmpNo("LB444");
		if (e.isPresent()) {
			throw new EmployeeAlreadyExists("Employee exists");
		}
		employeeRepository.save(employee);

		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getEmployeeTest() {

		Employee employee = employeeRepository.findByEmpNo("LB444").get();

		Assertions.assertThat(employee.getEmpNo()).isEqualTo("LB444");

	}

	@Test
	@Order(3)
	public void getListOfEmployeesTest() {

		List<Employee> employees = employeeRepository.findAll();

		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateEmployeeTest() {

		Employee employee = employeeRepository.findByEmpNo("LB444").get();

		employee.setEmpName("Silas");

		Employee employeeUpdated = employeeRepository.save(employee);

		Assertions.assertThat(employeeUpdated.getEmpName()).isEqualTo("Silas");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteEmployeeTest() {

		Employee employee = employeeRepository.findByEmpNo("LB444").get();

		employeeRepository.delete(employee);

		// employeeRepository.deleteById(1L);

		Employee employee1 = null;

		Optional<Employee> optionalEmployee = employeeRepository.findByEmpNo("LB444");

		if (optionalEmployee.isPresent()) {
			employee1 = optionalEmployee.get();
		}

		Assertions.assertThat(employee1).isNull();
	}
}
