package model;
public class LoginModel {
	private String userName;
	private String password;
	
	
	/**
	 * Parameterized Constructor of LoginModel Class
	 * @param userName
	 * @param password
	 */
	public LoginModel(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Getter method of userName attributes
	 * @return current value of userName 
	 */
	public String getUsername() {
		return userName;
	}
	/**
	 * Setter method of userName attributes 
	 * @param username
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}
	/**
	 * Getter method of password attributes
	 * @return current value of password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter method of password attributes
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}