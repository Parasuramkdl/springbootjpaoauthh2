package com.prokarma.springboot.jpa.h2.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author JavaSolutionsGuide
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

@Id
 @GeneratedValue(strategy= GenerationType.AUTO)
 private Long id;
 
 @Column(name="EMPLOYEE_NAME")
 private String name;
 
 @Column(name="EMPLOYEE_SALARY")
 private Integer salary;
 
 @Column(name="DEPARTMENT")
 private String department;
 
 @OneToOne(fetch = FetchType.LAZY,
         cascade =  CascadeType.ALL,
         mappedBy = "employee")
 private Address address;

 public Long getId() {
  return id;
 }

 public Employee setId(Long id) {
  this.id = id;
  return this;
 }

 public String getName() {
  return name;
 }

 public Employee setName(String name) {
  this.name = name;
  
  return this;
 }

 public Integer getSalary() {
  return salary;
 }

 public Employee setSalary(Integer salary) {
  this.salary = salary;
  return this;
 }

 public String getDepartment() {
  return department;
 }

 public Employee setDepartment(String department) {
  this.department = department;
  return this;
 }

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
 
 
}
