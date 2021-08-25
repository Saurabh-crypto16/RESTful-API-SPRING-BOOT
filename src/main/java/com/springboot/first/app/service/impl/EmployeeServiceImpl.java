package com.springboot.first.app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.Employee;
import com.springboot.first.app.repository.EmployeeRepository;
import com.springboot.first.app.service.EmployeeService;


//this class implements the EmployeeService Interface

@Service
public class EmployeeServiceImpl implements EmployeeService{

	/*Before implementing this method we have to inject the dependencies
	 * There are 2 ways to inject dependencies:
	 * 1.Setter based injection-to implement optional parameters
	 * 2.Constructor based injection-to implement mandatory parameters */
	
	//Constructor based injection
	private EmployeeRepository employeeRepository;
	
	//no need to add @Autowired because if there is only one constructor spring will automatically autowire it
	//@Autowire feature of spring framework enables you to inject the object dependency implicitly
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public ArrayList<Employee> getAllEmployees() {
		return (ArrayList<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//checking if employee with given id exists in db
		Employee existingEmployee= employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		
		//updating existing employee data
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save updated data to db
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//checking if employee with given id exists in db
		employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "ID", id));
		
		employeeRepository.deleteById(id);
	}
	
}
