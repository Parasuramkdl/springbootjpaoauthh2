package com.prokarma.springboot.jpa.h2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.springboot.jpa.h2.entity.Address;
import com.prokarma.springboot.jpa.h2.entity.Employee;
import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;
import com.prokarma.springboot.jpa.h2.service.EmployeeService;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
public class EmployeeRestController {
 
 @Autowired
 private EmployeeService employeeService;
 
 public void setEmployeeService(EmployeeService employeeService) {
  this.employeeService = employeeService;
 }

 @GetMapping("/api/employees")
 public List<EmployeeResource> getEmployees() {
  List<EmployeeResource> employees = employeeService.retrieveEmployees();
  return employees;
 }
 
 @GetMapping("/api/employees/{employeeId}")
 public EmployeeResource getEmployee(@PathVariable(name="employeeId")Long employeeId) {
  return employeeService.getEmployee(employeeId);
 }
 
 @PostMapping("/api/employees")
 public EmployeeResource saveEmployee(@RequestBody EmployeeResource employeeResource){
	 
   EmployeeResource employeeResourc =  employeeService.saveEmployee(employeeResource);
   System.out.println("Employee Saved Successfully");
  
  return employeeResourc;
 }
 
 @DeleteMapping("/api/employees/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
 
 @PutMapping("/api/employees/{employeeId}")
 public void updateEmployee(@RequestBody EmployeeResource employee,
   @PathVariable(name="employeeId")Long employeeId){
   EmployeeResource emp = employeeService.getEmployee(employeeId);
  if(emp != null){
	  employee.setId(emp.getId()); 	  
   employeeService.updateEmployee(employee);
  }
  
 }

}
