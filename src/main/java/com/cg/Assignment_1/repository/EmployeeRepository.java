package com.cg.Assignment_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.Assignment_1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByemployeeName(String employeeName);
	
	Employee findByemployeeMobile(String employeeMobile);
	
	Employee findByemployeeEmail(String employeeEmail);

}
