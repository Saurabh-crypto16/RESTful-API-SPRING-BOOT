package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.app.model.Employee;

//no need for @Repository and @Transactional because Spring internally provides it
//1st parameter is the name of JPA entity class and 2nd parameter is the datatype of id
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
