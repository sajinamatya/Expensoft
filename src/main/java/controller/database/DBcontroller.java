package controller.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Stringutils;

public class DBcontroller {

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

	    // Create a connection to the database using the provided credentials
	    return DriverManager.getConnection(Stringutils.LOCALHOST_URL, Stringutils.LOCALHOST_USERNAME,
	                                      Stringutils.LOCALHOST_PASSWORD);
	}
