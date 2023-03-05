package com.cg.Assignment_1.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Assignment_1.entity.Employee;
import com.cg.Assignment_1.exception.EmployeeAlreadyExistException;
import com.cg.Assignment_1.exception.EmployeeNotFoundException;
import com.cg.Assignment_1.exception.InvalidEntryException;
import com.cg.Assignment_1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		// Checking whether mobile number already exists before saving
		String mobile=employee.getEmployeeMobile();
		Employee existingEmployee = employeeRepository.findByemployeeMobile(mobile);
		if(existingEmployee !=null) {
			throw new EmployeeAlreadyExistException("Mobile Number already exists");
		}
		
		//Checking whether the entered email is valid or not
		String email=employee.getEmployeeEmail();
		Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		Matcher matcher = pattern.matcher(email);
		boolean emailValidate = matcher.matches();
		if(email !=null && !emailValidate) {
			throw new InvalidEntryException("Enter a valid email");
		}
		//Checking whether email already exists 
		existingEmployee = employeeRepository.findByemployeeEmail(email);
		if(existingEmployee !=null) {
			throw new EmployeeAlreadyExistException("Employee with Email Id already exist");
		}
		
		//Checking whether salary is positive value 
		double salary=employee.getEmployeeSalary();
		if(salary <=0) {
			throw new InvalidEntryException("Salary must be a positive value");
		}
		
		
		
		Employee newEmployee= employeeRepository.save(employee);
		return newEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList=employeeRepository.findAll();
		return empList;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			Employee emp1=employee.get();
			return emp1;
		}
		throw new EmployeeNotFoundException("Employee with given id: " + employeeId + "does not exist");
	}

	@Override
	public Employee getEmployeeByName(String employeeName) throws EmployeeNotFoundException {
		Employee employee=employeeRepository.findByemployeeName(employeeName);
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee not existed with name: "+employeeName);
		}
		else {
			return employee;
		}
		
	}

	@Override
	public void deleteEmployee(int employeeId) throws EmployeeNotFoundException{
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not existed with ID: "+employeeId);
		}
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> employee1=employeeRepository.findById(employee.getEmployeeId());
		if(employee1.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not existed with ID: "+ employee.getEmployeeId());
			
		}
		Employee employee2=employeeRepository.save(employee);
		return employee2;
	}

	

}
