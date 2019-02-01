package com.prokarma.springboot.jpa.h2.service;

import java.util.List;

import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;


/**
 * @author JavaSolutionsGuide
 *
 */
public interface EmployeeService {
 public List<EmployeeResource> retrieveEmployees();
 
 public EmployeeResource getEmployee(Long employeeId);
 
 public EmployeeResource saveEmployee(EmployeeResource employeeResource);
 
 public void deleteEmployee(Long employeeId);
 
 public EmployeeResource updateEmployee(EmployeeResource employee);
}
