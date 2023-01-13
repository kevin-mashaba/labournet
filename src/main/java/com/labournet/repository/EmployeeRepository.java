package com.labournet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.labournet.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//@Query(value = "select * from tbl_employee where empNo =:empNo",nativeQuery = true)
	Optional<Employee> findByEmpNo(@Param(value = "empNo")String empNo);
	//Employee updateEmployee(Employee employee);
}
