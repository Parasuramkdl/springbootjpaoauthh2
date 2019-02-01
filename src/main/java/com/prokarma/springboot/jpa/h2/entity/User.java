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
@Table(name="user")
public class User implements Serializable {
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

@Id
 @GeneratedValue(strategy= GenerationType.AUTO)
 private Long id;
 
 @Column(name="FIRST_NAME")
 private String firstName;
 
 @Column(name="LAST_NAME")
 private String lastName;
 
 @Column(name="USER_NAME")
 private String userName;
 
 @Column(name="EMAIL")
 private String email;
 
 @Column(name="PASSWORD")
 private String password;
 
 @Column(name="MOBILE")
 private Long mobileNumber;
 
@OneToOne(fetch = FetchType.LAZY,
         cascade =  CascadeType.ALL,
         mappedBy = "user")
 private UserProfile userProfile;

 public Long getId() {
  return id;
 }

 public User setId(Long id) {
  this.id = id;
  return this;
 }

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

/**
 * @return the mobileNumber
 */
public Long getMobileNumber() {
	return mobileNumber;
}

/**
 * @param mobileNumber the mobileNumber to set
 */
public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}

/**
 * @return the userProfile
 */
public UserProfile getUserProfile() {
	return userProfile;
}

/**
 * @param userProfile the userProfile to set
 */
public void setUserProfile(UserProfile userProfile) {
	this.userProfile = userProfile;
}

/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}

/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (userProfile == null) {
		if (other.userProfile != null)
			return false;
	} else if (!userProfile.equals(other.userProfile))
		return false;
	return true;
}


@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
			+ password + ", userProfile=" + userProfile + "]";
}

 


 
}
