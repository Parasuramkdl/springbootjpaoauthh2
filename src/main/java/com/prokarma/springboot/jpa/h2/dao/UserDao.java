package com.prokarma.springboot.jpa.h2.dao;

import org.springframework.data.repository.CrudRepository;

import com.prokarma.springboot.jpa.h2.entity.User;

public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUserName(String userName);

}
