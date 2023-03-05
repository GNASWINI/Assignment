package com.cg.Assignment_1.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	@NotBlank(message="Please enter Employee Name")
	@Column(name="employeeName")
	private String employeeName;
	
	@NotBlank(message="Please enter domain in which employee is working")
	@Column(name="employeeDomain")
	private String employeeDomain;
	
	@NotNull(message="Please enter employee salary")
	@Positive(message="Salary must be a positive number")
	@Column(name="employeeSalary")
	private double employeeSalary;
	
	@NotBlank(message="Please enter employee email Id")
	@Email
	@Column(name="employeeEmail")
	private String employeeEmail;
	
	@NotBlank(message="Please enter employee mobile number")
	//"^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$"
	@Pattern(regexp="^\\d{10}",message="Mobile number must be a 10-digit number")
	@Column(name="employeeMobile")
	private String employeeMobile;
	
	@NotBlank(message="Please enter employee Location")
	@Column(name="employeeLocation")
	private String employeeLocation;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeMobile() {
		return employeeMobile;
	}
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	
	
	
	
	

}
