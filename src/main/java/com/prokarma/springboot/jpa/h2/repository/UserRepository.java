package com.prokarma.springboot.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prokarma.springboot.jpa.h2.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
