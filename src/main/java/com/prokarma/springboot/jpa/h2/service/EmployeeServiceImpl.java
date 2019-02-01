package com.prokarma.springboot.jpa.h2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.springboot.jpa.h2.entity.Address;
import com.prokarma.springboot.jpa.h2.entity.Employee;
import com.prokarma.springboot.jpa.h2.repository.EmployeeRepository;
import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;

/**
 * @author JavaSolutionsGuide
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

 @Autowired
 private EmployeeRepository employeeRepository;

 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
  this.employeeRepository = employeeRepository;
 }
 
 public List<EmployeeResource> retrieveEmployees() {
  List<Employee> employees = employeeRepository.findAll();
  
  List<EmployeeResource> employeeResources = new ArrayList<>(); 
  
    
     employees.forEach(employee ->{
	  
	  EmployeeResource employeeResource = new EmployeeResource();
	  BeanUtils.copyProperties(employee, employeeResource);
	  employeeResources.add(employeeResource);
	  
  });
  
  return employeeResources;
 }
 
 public EmployeeResource getEmployee(Long employeeId) {
  Optional<Employee> optEmp = employeeRepository.findById(employeeId);
  Employee employee =  optEmp.get();
  
  EmployeeResource employeeResource = new EmployeeResource();
  
  BeanUtils.copyProperties(employee, employeeResource);
  
  return employeeResource;
 }
 
 public EmployeeResource saveEmployee(EmployeeResource employeeResource){
	 
	 Employee employee = buildSaveEmployee(employeeResource);
	 
     Employee emp = employeeRepository.save(employee);
     
     BeanUtils.copyProperties(emp, employeeResource);
     
     
     return employeeResource;
 }
 
 public void deleteEmployee(Long employeeId){
  employeeRepository.deleteById(employeeId);
 }
 
 public EmployeeResource updateEmployee(EmployeeResource employeeResource) {
	 
	 	
	 Employee employee = null;
	  
		 
	 employee = buildUpdateEmployee(employeeResource);
	 
	 Employee updatedEmp = employeeRepository.saveAndFlush(employee);
	 
	 BeanUtils.copyProperties(updatedEmp, employeeResource);
     
     return employeeResource;
 }
 
 
 private Employee buildUpdateEmployee(EmployeeResource employeeResource) {
	 
	 Employee employee = new Employee();
	 employee.setId(employeeResource.getId());
	 employee.setName(employeeResource.getName());
	 employee.setDepartment(employeeResource.getDepartment());
	 employee.setSalary(employeeResource.getSalary());
	 
	 
	 return employee;
 }
 
 private Employee buildSaveEmployee(EmployeeResource employeeResource) {
	 
	 Employee employee = new Employee();
	 
	 Address address = new Address();
	 
	 BeanUtils.copyProperties(employeeResource, employee);
	 
	 BeanUtils.copyProperties(employeeResource, address);
	 
	 address.setEmployee(employee); 
	 employee.setAddress(address); 
	 
	 return employee;
 }
}
