package com.cg.Assignment_1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Assignment_1.entity.Employee;
import com.cg.Assignment_1.service.EmployeeService;

@RestController

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
		Employee newEmployee=employeeService.saveEmployee(employee);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<> (newEmployee, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAll/Employees")
	public ResponseEntity<List<Employee>> fetchAllEmployees(){
		List<Employee> empList=employeeService.getAllEmployees();
		ResponseEntity<List<Employee>> responseEntity=new ResponseEntity<>(empList,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/employee/id/{id}")
	public ResponseEntity<Employee> fetchEmployeeById(@PathVariable("id") int employeeId){
		ResponseEntity<Employee> responseEntity=null;
		Employee employee=employeeService.getEmployeeById(employeeId);
		responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") int employeeId){
		//ResponseEntity<String> responseEntity=null;
		employeeService.deleteEmployee(employeeId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Employee Deleted Successfully.",HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PutMapping("/employee/update")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(employee);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(updateEmployee, HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/get/employeeBy/name/{name}")
	public ResponseEntity<Employee> fetchEmployeeByName(@PathVariable("name") String employeeName){
		
		ResponseEntity<Employee> responseEntity=null;
		Employee employee=employeeService.getEmployeeByName(employeeName);
		responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
		return responseEntity;
	}

}
