package com.springboot.first.app.service;

import java.util.ArrayList;

import com.springboot.first.app.model.Employee;

//Controller depends on Service

public interface EmployeeService {
	//we will define these methods in EmployeeServiceImpl
	Employee saveEmployee(Employee employee);
	ArrayList<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
