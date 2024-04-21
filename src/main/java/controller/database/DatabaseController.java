package controller.database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.SignupModel;
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
	
	public int signupUser(SignupModel user) {

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
	        st.setString(8, user.getPassword());
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

	public Boolean checkNumberIfExists(String number) {
	    // TODO: Implement logic to check if the provided phone number exists in the database
	    // This method should likely query the database using DBController and return true if the phone number exists, false otherwise.
	    return false;
	}

	public Boolean checkUsernameIfExists(String username) {
	    // TODO: Implement logic to check if the provided username exists in the database
	    // This method should likely query the database using DBController and return true if the username exists, false otherwise.
	    return false;
	}
	
}