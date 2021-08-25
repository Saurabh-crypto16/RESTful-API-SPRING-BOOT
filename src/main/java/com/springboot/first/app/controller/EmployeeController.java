package com.springboot.first.app.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.model.Employee;
import com.springboot.first.app.service.EmployeeService;

@RestController	//makes this class a Controller class
@RequestMapping("/api/employees")	//base url
public class EmployeeController {

	//injecting dependencies
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	//Create Employee REST API
	@PostMapping()
	//@RequestBody allows us to retrieve the requests body and automatically convert it to java object
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), 
				HttpStatus.CREATED);
	}
	
	//get all employee REST API
	@GetMapping
	public ArrayList<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//get employee by id REST API
	//demo url - http://localhost:8081/api/employees/1 
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), 
				HttpStatus.CREATED);
	}
	
	//update employee REST API
	//demo url - http://localhost:8081/api/employees/1 
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, 
			@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), 
				HttpStatus.OK);
	}
	
	//delete employee REST API
	//demo url - http://localhost:8081/api/employees/1 
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!👍👍", HttpStatus.OK);
	}
	
}







