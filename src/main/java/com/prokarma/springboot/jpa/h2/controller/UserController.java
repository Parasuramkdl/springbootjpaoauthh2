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

import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;
import com.prokarma.springboot.jpa.h2.resource.UserResource;
import com.prokarma.springboot.jpa.h2.service.EmployeeService;
import com.prokarma.springboot.jpa.h2.service.UserService;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
public class UserController {
 
 @Autowired
 private UserService userService;
 
 public void setUserService(UserService userService) {
  this.userService = userService;
 }

 @GetMapping("/api/users")
 public List<UserResource> getUsers() {
  List<UserResource> userResources = userService.retrieveUsers();
  return userResources;
 }
 
 @GetMapping("/api/users/{userId}")
 public UserResource getUser(@PathVariable(name="employeeId")Long userId) {
  return userService.getUser(userId);
 }
 
 @PostMapping("/api/users")
 public UserResource saveUser(@RequestBody UserResource userResource){
	 
   UserResource userResourc =  userService.saveUser(userResource);
   System.out.println("User Saved Successfully");
  
  return userResourc;
 }
 
 @DeleteMapping("/api/users/{userId}")
 public void deleteUser(@PathVariable(name="userId")Long userId){
  userService.deleteUser(userId);
  System.out.println("User Deleted Successfully");
 }
 
 @PutMapping("/api/users/{userId}")
 public void updateUser(@RequestBody UserResource user,
   @PathVariable(name="userId")Long userId){
   UserResource userr = userService.getUser(userId);
  if(userr != null){
	  user.setId(userr.getId()); 	  
   userService.updateUser(user);
  }
  
 }

}
