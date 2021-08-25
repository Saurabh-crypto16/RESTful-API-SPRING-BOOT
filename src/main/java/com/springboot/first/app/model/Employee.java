//JPA entity

/* Java Persistence API (JPA) is a specification of Java. 
 * It is used to persist data between Java object and relational database. 
 * JPA acts as a bridge between object-oriented domain models and relational database systems.
 * As JPA is just a specification, 
 * it doesn't perform any operation by itself. 
 * It requires an implementation. So, ORM tools like 
 * Hibernate, TopLink and iBatis implements JPA specifications for data persistence*/


/*Lombok library is ued to reduce boilerplate code like getter, setter,constructors, toString,
 * equals and hashacode methods for java*/

package com.springboot.first.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
 
@Entity	//specifies class is a JPA entity
@Table(name="employees")	//specifies table in db whith which this entity is mapped
public class Employee {
	
	@Id	//specifies primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//specifies the generation strategies for value of primary keys
	private long id;
	
	//creating column in database with column name=column_name
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	//constructor
	public Employee() {
		super();
	}

	public Employee(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}




