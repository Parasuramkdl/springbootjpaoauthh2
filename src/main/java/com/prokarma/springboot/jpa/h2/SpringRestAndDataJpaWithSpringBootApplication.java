package com.prokarma.springboot.jpa.h2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.prokarma.springboot.jpa.h2.resource.EmployeeResource;
import com.prokarma.springboot.jpa.h2.resource.UserResource;
import com.prokarma.springboot.jpa.h2.service.EmployeeService;
import com.prokarma.springboot.jpa.h2.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.prokarma.springboot.jpa.h2")
public class SpringRestAndDataJpaWithSpringBootApplication {
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserService userService;
	
 public static void main(String[] args) {
  SpringApplication.run(SpringRestAndDataJpaWithSpringBootApplication.class, args);
 }
 
/* @Component
 public class CorsFilter extends OncePerRequestFilter {

         @Override
         protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
             response.setHeader("Access-Control-Allow-Origin", "*");
             response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
             response.setHeader("Access-Control-Max-Age", "3600");
             response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
             response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
             if ("OPTIONS".equals(request.getMethod())) {
                 response.setStatus(HttpServletResponse.SC_OK);
             } else {
                 filterChain.doFilter(request, response);
             }
         }
 }*/
 @Component
 public class CommandLineAppStartupRunner implements CommandLineRunner {
     @Override
     public void run(String...args) throws Exception {
    	 
    	List<UserResource> users =  userService.retrieveUsers();
    	 
    	if(users.isEmpty()) {
    		
    		UserResource user = new UserResource();
    		user.setFirstName("Parasuram");
    		user.setLastName("Yerramsetty");
    		user.setUserName("ram");
    		user.setEmail("yparasuram@prokarma.com");
    		user.setCity("Hyderabad");
    		user.setState("Telangana");
    		user.setCountry("India");
    		user.setMobileNumber(9885256123L);
    		user.setPassword("admin");
    		user.setAddressline1("Near HCU"); 
    		user.setAddressline2("lingampally");
    		user.setStreet("Sudharshan nagar colony");
    		user.setPincode("500019");
    		user.setPasswordLength(user.getPassword().length());
    		user.setPasswordFailedAttemptCount(0);
    		
    		UserResource userResurce = userService.saveUser(user);
    		
    	}
    	 
    	 List<EmployeeResource> employees = employeeService.retrieveEmployees();
    	 
    	 if(employees.isEmpty()) {
    		 
    		 
    		 EmployeeResource e3 = new EmployeeResource();
    		 e3.setId(1L);
    		 e3.setName("suresh");
    		 e3.setDepartment("IT");
    		 e3.setSalary(25000);
    		 e3.setCity("hyd");
    		 e3.setState("telangana"); 
    		
    		 
    		 employeeService.saveEmployee(e3);
    		 
    		
    	 }
     }
 }
}