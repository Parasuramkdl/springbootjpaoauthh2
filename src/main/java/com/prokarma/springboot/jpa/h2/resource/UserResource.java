package com.prokarma.springboot.jpa.h2.resource;

public class UserResource {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Long mobileNumber;
	private String city;
	private String state;
	private String street;
	private String country;
	private String pincode;

	private String addressline1;

	private String addressline2;

	private Integer passwordLength;

	private Integer passwordFailedAttemptCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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
	public Integer getPasswordLength() {
		return passwordLength;
	}

	/**
	 * @param passwordLength the passwordLength to set
	 */
	public void setPasswordLength(Integer passwordLength) {
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

		
}
