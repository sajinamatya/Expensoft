package model;
import java.time.LocalDate;

public class UserModel{
	
	private String fullName;
	private String email;
	private String userName;
	private String gender;
	private String phoneNumber;
	private String address ; 
	private String password;
	private String securityQn;
	private LocalDate dateOfBirth;
	
	/**
	 * Parameterized Constructor for SignupModel Class
	 * @param fullName
	 * @param email
	 * @param userName
	 * @param gender
	 * @param phoneNumber
	 * @param address
	 * @param password
	 * @param securityQn
	 * @param dateOfBirth
	 */
	
	public UserModel() {
	}
	public UserModel(String fullName, String email, String userName, String gender, String phoneNumber,
			String address, String password, String securityQn, LocalDate dateOfBirth) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.securityQn = securityQn;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Getter method for fullName attributes
	 * @return current value of fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Setter method for fullName parameter 
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Getter Method for email attributes
	 * @return current value of the email attributes 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method of email attributes 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method  for userName attributes
	 * @return current value of userName attributes
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method for userName attributes
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method for gender attributes
	 * @return current value of gender attribute
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter method for gender attributes
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Getter method for phoneNumber attributes
	 * @return current value of phoneNumber attributes
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter method for phoneNumber attributes
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter method for address attributes 
	 * @return current value of address attributes
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for address attributes 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter method for password attributes 
	 * @return current value of password attributes 
	 */
	public String getPassword() {
		return password;
	}

	/** Setter method for password attributes 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for securityQn attributes 
	 * @return current value of securityQn
	 */
	public String getSecurityQn() {
		return securityQn;
	}

	/**
	 * Setter method for securityQN
	 * @param securityQn
	 */
	public void setSecurityQn(String securityQn) {
		this.securityQn = securityQn;
	}

	/**
	 * Getter method for dateOfBirth attributes 
	 * @return current value of dateOfBirth attributes 
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Setter method for dateOfBirth attributes
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
	
	
	
}