package controller.database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public int signUpUser(SignupModel user) {

	    try {
	        // Prepare a statement using the predefined sql query for user sign up
	        PreparedStatement stmt = getConnection()
	        		.prepareStatement(Stringutils.QUERY_SIGNUP_USER);

	        // Set the user detail in the prepared statement
	        stmt.setString(1, user.getFullName());
	        stmt.setString(2, user.getEmail());
	        stmt.setDate(3, Date.valueOf(user.getDateOfBirth()));
	        stmt.setString(4, user.getGender());
	        stmt.setString(5, user.getPhoneNumber());
	        stmt.setString(6, user.getAddress());
	        stmt.setString(7, user.getUserName());
	        stmt.setString(8, user.getPassword());

	        // Execute the update statement and store the number of affected rows
	        int result = stmt.executeUpdate();

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
	
}