package model;
import java.io.File;
import java.time.LocalDate;

import javax.servlet.http.Part;


import utils.Stringutils;

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
	private String imageUrlFromPart; 
	
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
			String address, String password, String securityQn, LocalDate dateOfBirth, Part imagePart) {
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
		this.imageUrlFromPart = getImageUrl(imagePart);
	}
	public UserModel(String fullName, String email, String userName, String phoneNumber,
			String address ) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	
	}
	

	/**
	 * getter method fro imageurlFromPart 
	 * @return imageUrlFromPart 
	 */
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}
	/**
	 * setter method for imageUrlFromPart
	 * @param imageUrlFromPart
	 */
	public void setImageUrlFromPart(String imageUrlFromPart) {
		this.imageUrlFromPart = imageUrlFromPart;
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
	
	private String getImageUrl(Part part) {
		// Define the directory path to store uploaded user images. This path should be configured elsewhere in the application.
	    String savePath = Stringutils.IMAGE_DIR_USER;

	    // Create a File object representing the directory to store uploaded images.
	    File fileSaveDir = new File(savePath);

	    // Initialize the variable to store the extracted image file name.
	    String imageUrlFromPart = null;

	    // Check if the directory to store uploaded images already exists.
	    if (!fileSaveDir.exists()) {
	        // If the directory doesn't exist, create it.
	    	// user mkdirs() method to create multiple or nested folder
	        fileSaveDir.mkdir();
	    }

	    // Get the Content-Disposition header from the request part. This header contains information about the uploaded file, including its filename.
	    String contentDisp = part.getHeader("content-disposition");

	    // Split the Content-Disposition header into individual parts based on semicolons.
	    String[] items = contentDisp.split(";");

	    // Iterate through each part of the Content-Disposition header.
	    for (String s : items) {
	        // Check if the current part starts with "filename" (case-insensitive trim is used).
	        if (s.trim().startsWith("filename")) {
	            // Extract the filename from the current part.
	            // The filename is assumed to be enclosed in double quotes (").
	            // This part removes everything before the equal sign (=) and the double quotes surrounding the filename.
	            imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
	            break; // Exit the loop after finding the filename
	        }
	    }

	    // If no filename was extracted from the Content-Disposition header, set a default filename.
	    if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
	        imageUrlFromPart = "default_user.jpg";
	    }

	    // Return the extracted or default image file name.
	    return imageUrlFromPart;
	}
	
	
	
	
	
}