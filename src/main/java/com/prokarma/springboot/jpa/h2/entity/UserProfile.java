package com.prokarma.springboot.jpa.h2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author JavaSolutionsGuide
 *
 */
@Entity
@Table(name="user_profile")
public class UserProfile implements Serializable {
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="password")
 private String password;
 
 @Column(name="city")
 private String city;
 
 @Column(name="state")
 private String state;
 
 @Column(name="country")
 private String country;
 
 @Column(name="pincode")
 private String pincode;
 
 @Column(name="addressline1")
 private String addressline1;

 @Column(name="addressline2")
 private String addressline2;
 
 @Column(name="passwordLength")
 private String passwordLength;
 
 @Column(name="passwordFailedAttemptCount")
 private Integer passwordFailedAttemptCount;
 
 
 @OneToOne(fetch = FetchType.LAZY, optional = false)
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

 public Long getId() {
  return id;
 }

 public UserProfile setId(Long id) {
  this.id = id;
  return this;
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
 * @return the city
 */
public String getCity() {
	return city;
}

/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}

/**
 * @return the state
 */
public String getState() {
	return state;
}

/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}

/**
 * @return the country
 */
public String getCountry() {
	return country;
}

/**
 * @param country the country to set
 */
public void setCountry(String country) {
	this.country = country;
}

/**
 * @return the pincode
 */
public String getPincode() {
	return pincode;
}

/**
 * @param pincode the pincode to set
 */
public void setPincode(String pincode) {
	this.pincode = pincode;
}

/**
 * @return the addressline1
 */
public String getAddressline1() {
	return addressline1;
}

/**
 * @param addressline1 the addressline1 to set
 */
public void setAddressline1(String addressline1) {
	this.addressline1 = addressline1;
}

/**
 * @return the addressline2
 */
public String getAddressline2() {
	return addressline2;
}

/**
 * @param addressline2 the addressline2 to set
 */
public void setAddressline2(String addressline2) {
	this.addressline2 = addressline2;
}

/**
 * @return the passwordLength
 */
public String getPasswordLength() {
	return passwordLength;
}

/**
 * @param passwordLength the passwordLength to set
 */
public void setPasswordLength(String passwordLength) {
	this.passwordLength = passwordLength;
}

/**
 * @return the passwordFailedAttemptCount
 */
public Integer getPasswordFailedAttemptCount() {
	return passwordFailedAttemptCount;
}

/**
 * @param passwordFailedAttemptCount the passwordFailedAttemptCount to set
 */
public void setPasswordFailedAttemptCount(Integer passwordFailedAttemptCount) {
	this.passwordFailedAttemptCount = passwordFailedAttemptCount;
}

/**
 * @return the user
 */
public User getUser() {
	return user;
}

/**
 * @param user the user to set
 */
public void setUser(User user) {
	this.user = user;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((addressline1 == null) ? 0 : addressline1.hashCode());
	result = prime * result + ((addressline2 == null) ? 0 : addressline2.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((passwordFailedAttemptCount == null) ? 0 : passwordFailedAttemptCount.hashCode());
	result = prime * result + ((passwordLength == null) ? 0 : passwordLength.hashCode());
	result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	UserProfile other = (UserProfile) obj;
	if (addressline1 == null) {
		if (other.addressline1 != null)
			return false;
	} else if (!addressline1.equals(other.addressline1))
		return false;
	if (addressline2 == null) {
		if (other.addressline2 != null)
			return false;
	} else if (!addressline2.equals(other.addressline2))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (passwordFailedAttemptCount == null) {
		if (other.passwordFailedAttemptCount != null)
			return false;
	} else if (!passwordFailedAttemptCount.equals(other.passwordFailedAttemptCount))
		return false;
	if (passwordLength == null) {
		if (other.passwordLength != null)
			return false;
	} else if (!passwordLength.equals(other.passwordLength))
		return false;
	if (pincode == null) {
		if (other.pincode != null)
			return false;
	} else if (!pincode.equals(other.pincode))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}

 


 
 
}
