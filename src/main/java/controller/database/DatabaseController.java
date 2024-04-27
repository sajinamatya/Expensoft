package controller.database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.ExpenseModel;
import model.IncomeModel;
import model.LoginModel;
import model.PasswordEncryptionWithAes;
import model.UserModel;

import utils.Stringutils;

public class DatabaseController  {

	/**
	 * Create a connection to the database using pre-defined credentials and driver information.
	 * 
	 * @return A `Connection` object representing the established connection to the database.
	 * @throws SQLException if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException {

	    // Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
	    Class.forName(Stringutils.DRIVER_NAME);

	    // Create a connection to the database using the provided credentials from Stringutils 
	    return DriverManager.getConnection(Stringutils.LOCALHOST_URL, Stringutils.LOCALHOST_USERNAME,
	                                      Stringutils.LOCALHOST_PASSWORD);
	}
	
	/**
	 * @param user object of SignupModel class 
	 * @return 
	 */
	public int signupUser(UserModel user) {

	    try {
	        // Prepare a statement using the predefined sql query for user sign up
	        PreparedStatement st = getConnection()
	        		.prepareStatement(Stringutils.QUERY_SIGNUP_USER);

	        // Set the user detail in the prepared statement
	        st.setString(1, user.getFullName());
	        st.setString(2, user.getEmail());
	        st.setDate(3, Date.valueOf(user.getDateOfBirth()));
	        st.setString(4, user.getGender());
	        st.setString(5, user.getPhoneNumber());
	        st.setString(6, user.getAddress());
	        st.setString(7, user.getUserName());
	        st.setString(8, PasswordEncryptionWithAes.encrypt(
	        		user.getUserName(), user.getPassword()));
	        st.setString(9,user.getSecurityQn());

	        // Execute the update statement and store the number of affected rows
	        int result = st.executeUpdate();

	        // Check if the update was successful (i.e., at least one row affected)
	        if (result > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed (no rows affected)
	        }

	    } catch (ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        return -1; // Internal error
	    }
	}
	/**
	 * @param email
	 * @return
	 */
	public Boolean checkEmailIfExists(String email) {
		
		try {
			PreparedStatement stm = getConnection()
	        		.prepareStatement(Stringutils.QUERY_CHECK_EMAIL);
			stm.setString(1, email);
			ResultSet result = stm.executeQuery();
			if(result.next()) {
				return true;
			}
		 }
		catch(ClassNotFoundException | SQLException ex)
		{	   
			  ex.printStackTrace();
		  
		}
		return false;
	    
	}

	/**
	 * @param number
	 * @return
	 */
	public Boolean checkNumberIfExists(String number) {
	    
		try {
			PreparedStatement stm = getConnection()
	        		.prepareStatement(Stringutils.QUERY_CHECK_PHONENUMBER);
			stm.setString(1, number);
			ResultSet result = stm.executeQuery();
			if(result.next()) {
				return true;
			}
		 }
		catch(ClassNotFoundException | SQLException ex)
		{	   
			  ex.printStackTrace();
		  
		}
		return false;
	}

	/**
	 * @param username
	 * @return
	 */
	public Boolean checkUsernameIfExists(String username) {
		try {
			PreparedStatement stm = getConnection()
	        		.prepareStatement(Stringutils.QUERY_CHECK_USERNAME);
			stm.setString(1, username);
			ResultSet result = stm.executeQuery();
			if(result.next()) {
				return true;
			}
		 }
		catch(ClassNotFoundException | SQLException ex)
		{	   
			  ex.printStackTrace();
		  
		}
		return false;
	    
	}
	/**
	 * @param loginModel
	 * @return
	 */
	public  int getUserLoginInfo(LoginModel loginModel) {
		
	
	    // Try-catch block to handle potential SQL or ClassNotFound exceptions
	    try {
	        // Prepare a statement using the predefined query for login check
	        PreparedStatement st = getConnection()
	        		.prepareStatement(Stringutils.QUERY_LOGIN_USER_CHECK);

	        // Set the user name in the first parameter of the prepared statement
	        st.setString(1, loginModel.getUsername());

	        // Execute the query and store the result set
	        ResultSet result = st.executeQuery();

	        // Check if there's a record returned from the query
	        if (result.next()) {
	            // Get the username from the database
	            String userDb = result.getString(Stringutils.USER_NAME);

	            // Get the password from the database
	            String encryptedPwd = result.getString(Stringutils.PASSWORD);

	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
	            // Check if the username and password match the credentials from the database
	            if(userDb.equals("admin") && decryptedPwd.equals("admin")) {
	            	return 3; 
	            }
	            else if (userDb.equals(loginModel.getUsername()) 
	            		&& decryptedPwd.equals(loginModel.getPassword())) {
	                // Login successful, return 1
	                return 1;
	            } else {
	                // Username or password mismatch, return 0
	                return 0;
	            }
	        } else {
	            // Username not found in the database, return -1
	            return -1;
	        }

	    // Catch SQLException and ClassNotFoundException if they occur
	    } catch (SQLException | ClassNotFoundException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        // Return -2 to indicate an internal error
	        return -2;
	    }
	}
	
	public int extractUser_Id(String username) {
		try{
			PreparedStatement st = getConnection()
        		.prepareStatement(Stringutils.QUERY_GET_USER_ID);
			st.setString(1, username);
			ResultSet result = st.executeQuery();
			if(result.next()) {
				int user_id = result.getInt(Stringutils.USER_ID);
				return user_id;
			}
			else { return -1; }
		
		
		}
		catch(ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        return -2; // Internal error
	    }
		
	}
	public int userExpense(ExpenseModel expense) {
		try {
			
			PreparedStatement st = getConnection()
	        		.prepareStatement(Stringutils.QUERY_USER_EXPENSE);
			 // Set the user detail in the prepared statement
	        st.setInt(1,expense.getUser_id());
	        st.setFloat(2,expense.getExpense_amount() );
	        st.setDate(3, Date.valueOf(expense.getExpense_date()));
	        st.setString(4, expense.getExpense_category());
	        st.setString(5, expense.getExpense_description());
	        

	        // Execute the update statement and store the number of affected rows
	        int result = st.executeUpdate();
	     // Check if the update was successful (i.e., at least one row affected)
	        if (result > 0) {
	            return 1; // Expense added successful
	        } 
	        else {
	            return 0; // Expense adding process  failed (no rows affected)
	        }
			
			
			
		}	
			
	
		// Check if the update was successful (i.e., at least one row affected)
       

     catch (ClassNotFoundException | SQLException ex) {
        // Print the stack trace for debugging purposes
        ex.printStackTrace();
        return -1; // Internal error
    }
		
		
		
	}
	public int userIncome(IncomeModel income) {
		try {
			
			PreparedStatement st = getConnection()
	        		.prepareStatement(Stringutils.QUERY_USER_INCOME);
			 // Set the user detail in the prepared statement
	        st.setInt(1,income.getUser_id());
	        st.setFloat(2,income.getIncome_amount() );
	        st.setDate(3, Date.valueOf(income.getIncome_date()));
	        st.setString(4, income.getIncome_category());
	        st.setString(5, income.getIncome_description());
	        

	        // Execute the update statement and store the number of affected rows
	        int result = st.executeUpdate();
	     // Check if the update was successful (i.e., at least one row affected)
	        if (result > 0) {
	            return 1; // Expense added successful
	        } 
	        else {
	            return 0; // Expense adding process  failed (no rows affected)
	        }
			
			
			
		}	
			
	
		// Check if the update was successful (i.e., at least one row affected)
       

     catch (ClassNotFoundException | SQLException ex) {
        // Print the stack trace for debugging purposes
        ex.printStackTrace();
        return -1; // Internal error
    }
	}
	
	
	public ArrayList<UserModel> getAllUserInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_GET_ALL_STUDENTS);
			ResultSet result = stmt.executeQuery();

			ArrayList<UserModel> userArraylist = new ArrayList<UserModel>();

			while (result.next()) {
				UserModel users = new UserModel();
				users.setFullName(result.getString("Full_name"));
				users.setDateOfBirth(result.getDate("date_of_birth").toLocalDate());
				users.setEmail(result.getString("email"));
				users.setGender(result.getString("gender"));
				users.setPhoneNumber(result.getString("number"));
				
				student.setImageUrlFromDB(result.getString("image"));
				student.setUsername(result.getString("user_name"));				
				students.add(student);
			}
			return students;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int deleteStudentInfo(String username) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(Stringutils.QUERY_DELETE_USER);
			st.setString(1, username);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	}
