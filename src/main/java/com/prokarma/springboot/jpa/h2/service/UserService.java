package com.prokarma.springboot.jpa.h2.service;

import java.util.List;

import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;
import com.prokarma.springboot.jpa.h2.resource.UserResource;


/**
 * @author JavaSolutionsGuide
 *
 */
public interface UserService {
 public List<UserResource> retrieveUsers();
 
 public UserResource getUser(Long userId);
 
 public UserResource saveUser(UserResource userResource);
 
 public void deleteUser(Long userId);
 
 public UserResource updateUser(UserResource userResource);
}
