package com.cg.Assignment_1.service;

import java.util.List;

import com.cg.Assignment_1.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int employeeId);
	public Employee getEmployeeByName(String employeeName);
	public void deleteEmployee(int employeeId);
	public Employee updateEmployee(Employee employee);


}
