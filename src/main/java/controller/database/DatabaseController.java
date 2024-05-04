package controller.database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * This method register the user and save their details into the database
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
	        st.setString(10, user.getImageUrlFromPart());

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
	 * This method check if the email is already exist or not 
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
	 * This method check if the Phone number exist in the database or not 
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
	/**
	 * This method check if the username exist in the database or not 
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
	 * This method perform login operation by checking if the user entered username and password matches the database data and redirect them to the system page
	 * @param loginModel
	 * @return
	 */
	public  int getUserLoginInfo(LoginModel loginModel) {
		
	
	    // Try-catch block to handle potential SQL or ClassNotFound exceptions
	    try {
	        // Prepare a statement using the predefined query for login check
	        PreparedStatement st = getConnection()
	        		.prepareStatement(Stringutils.QUERY_USER_CHECK);

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
	
	/**
	 * This method extract user_id of the user from the database 
	 * @param username
	 * @return
	 */
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
	/**
	 *  This method add the expense of the user to the system 
	 * @param expense  entered by the user 
	 * @return
	 */
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
	public double getTotalExpenseOfUser(int user_id) {
		 
		try { 
			PreparedStatement st1 = getConnection().prepareStatement(Stringutils.QUERY_TOTAL_EXPENSE);
			st1.setInt(1, user_id);
			ResultSet result = st1.executeQuery();
			      
			if(result.next()) 
			{
				
				double totalexpense = result.getDouble("total_expense");
				
				return totalexpense;
			}
			else {
				return 1;
			}
		}
		catch (ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        // Internal error
	        return 0;
	    }	
	}
	
	public double getTotalIncomeOfUser(int user_id) {
		 
		try { 
			PreparedStatement st2 = getConnection().prepareStatement(Stringutils.QUERY_TOTAL_INCOME);
			st2.setInt(1, user_id);
			ResultSet result = st2.executeQuery();
			      
			if(result.next()) 
			{
				
				double totalincome = result.getDouble("total_income");
				
				return totalincome;
			}
			else {
				return 1;
			}
		}
		catch (ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        ex.printStackTrace();
	        // Internal error
	        return 0;
	    }	
	}
	
	
	
	/**
	 * This method adds the income of the user to the system
	 * @param income  given by the user 
	 * @return
	 */
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
	
	
	/**
	 * This method updates the user detail of the user by performing update query
	 * @param user
	 * @param user_id
	 * @return integer
	 */
	public int updateUserProfile(UserModel user, int user_id) {
		
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_UPDATE_USER_PROFILE);
			
			 stmt.setString(1,user.getFullName());
			 stmt.setString(2,user.getEmail());
			 stmt.setString(3,user.getPhoneNumber());
			 stmt.setString(4,user.getAddress());
			 stmt.setString(5,user.getUserName());
			 stmt.setInt(6,user_id);
			 int result = stmt.executeUpdate();
			 
		     // Check if the update was successful (i.e., at least one row affected)
		        if (result > 0) {
		            return 1; // user data updated   successful
		        } 
		        else {
		            return 0; // user updating   process  failed (no rows affected)
		        }
				
			
			
		}
		catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
		
	}
		
	/**
	 * This method update the password of the user
	 * @param newpass   new password enter by user 
	 * @param oldpass    old password enter by user 
	 * @param username   username of user 
	 * @return
	 */
	public int changePassword( String newpass, String oldpass, String username ) {
		
		try{
			PreparedStatement st = getConnection()
        		.prepareStatement(Stringutils.QUERY_USER_CHECK);
			st.setString(1, username);
			
			ResultSet result = st.executeQuery();
			
			if(result.next()) {
				
				String encryptedPwd = result.getString(Stringutils.PASSWORD);
	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, username);
	            if(decryptedPwd.equals(oldpass)) {
	            	PreparedStatement st1 = getConnection()
	            			.prepareStatement(Stringutils.QUERY_USER_PASSWORD_UPDATE);
	            	st1.setString(1, PasswordEncryptionWithAes.encrypt(
	            			username, newpass));
	            	st1.setString(2, username);
	            	int result1 = st1.executeUpdate();
				 
			     // Check if the update was successful (i.e., at least one row affected)
			        	if (result1 > 0) {
			            return 1; // user passsword  updated   successful
			        	} 
			        	else {
			        		return 0; // user updating password    process  failed (no rows affected)
			        	}
				
				}
				else 
				{ 
			
					return -1; // password didn't match 
					}
		
			}
			else 
			{return 2;}
		}
		catch(ClassNotFoundException | SQLException ex) {
	        // Print the stack trace for debugging purposes
	        	ex.printStackTrace();
	        	return -2; // Internal error
	    }	
	}
	
	public ArrayList<IncomeModel> getAllIncomeUserInfo(int user_id) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_GET_ALL_INCOME);
			stmt.setInt(1, user_id);
			ResultSet result = stmt.executeQuery();

			ArrayList<IncomeModel> IncomeArraylist = new ArrayList<IncomeModel>();

			while (result.next()) {
				IncomeModel Income = new IncomeModel();
				
				Income.setIncome_amount(result.getFloat("Income_amount"));
				Income.setIncome_category(result.getString("Income_category"));
				Income.setIncome_description(result.getString("Income_description"));
				Income.setIncome_date(result.getDate("Income_date").toLocalDate());
				IncomeArraylist.add(Income);
			}
			
		    return IncomeArraylist;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}	
	
	
	
	public ArrayList<ExpenseModel> getAllExpenseUserInfo(int user_id) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_GET_ALL_EXPENSE);
			stmt.setInt(1, user_id);
			ResultSet result = stmt.executeQuery();

			ArrayList<ExpenseModel> ExpenseArraylist = new ArrayList<ExpenseModel>();

			while (result.next()) {
				ExpenseModel expense = new ExpenseModel();
				expense.setExpense_amount(result.getFloat("expense_amount"));
				expense.setExpense_category(result.getString("expense_category"));
				expense.setExpense_description(result.getString("expense_description"));
				expense.setExpense_date(result.getDate("expense_date").toLocalDate());
				ExpenseArraylist.add(expense);
			}
			
		    return ExpenseArraylist;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}	
		
		
	
	
	/**
	 * This method retreives details of all the user from the database  of the system and stores into ArrayList 
	 * @return ArrayList which contain detail of every user in the system
	 */
	public ArrayList<UserModel> getAllUserInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_GET_ALL_USER);
			ResultSet result = stmt.executeQuery();

			ArrayList<UserModel> userArraylist = new ArrayList<UserModel>();

			while (result.next()) {
				UserModel users = new UserModel();
				users.setFullName(result.getString("full_name"));
				users.setDateOfBirth(result.getDate("date_of_birth").toLocalDate());
				users.setEmail(result.getString("email"));
				users.setGender(result.getString("gender"));
				users.setPhoneNumber(result.getString("phone_number"));
				users.setUserName(result.getString("user_name"));	
				users.setAddress(result.getString("address"));
				userArraylist.add(users);
			}
			
		    return userArraylist;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * This method retrieves the user detail from the database and create a session and update the details to it if the login is sucessful
	 * @param username
	 * @param request
	 * @param response
	 * @throws SQLException  ClassNotFoundException 
	 */
	public void setUserdetailToSession(String username,HttpServletRequest request, HttpServletResponse response) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(Stringutils.QUERY_USER_CHECK);
			stmt.setString(1,username);
			ResultSet result = stmt.executeQuery();
			
			
			

			while (result.next()) {
				String user_id = String.valueOf(result.getInt("user_id"));
				String fullname = result.getString("full_name");
				String email = result.getString("email");
				String gender = result.getString("gender");
				String address = result.getString("address");
				String user_name = result.getString("user_name");
				String phone = result.getString("phone_number");
				Date date = result.getDate("date_Of_birth");
				String imageurl = result.getString("image");
				
				HttpSession session = request.getSession(true);
				session.setAttribute(Stringutils.USERNAME, user_name);
				session.setAttribute(Stringutils.USER_ID, user_id);
				session.setAttribute("email", email);
				session.setAttribute("gender", gender);
				session.setAttribute("address", address);
				session.setAttribute("phone", phone);
				session.setAttribute("fullname", fullname);
				session.setAttribute("image", imageurl);
				session.setAttribute("date",date);
				session.setMaxInactiveInterval(30*60);
				
				Cookie userCookie= new Cookie(Stringutils.USER, user_name);
				Cookie userCookieId = new Cookie("user_id",user_id);
				Cookie userCookieEmail = new Cookie("email", email);
				Cookie userCookiePhone = new Cookie("phonenumber",phone);
				Cookie userCookieGender = new Cookie("gender",gender);
				Cookie userCookieDate = new Cookie("date",date.toString());
				userCookie.setMaxAge(30*60);
				response.addCookie(userCookie);
				response.addCookie(userCookieId);
				response.addCookie(userCookieEmail);
				response.addCookie(userCookiePhone);
				response.addCookie(userCookieGender);
				response.addCookie(userCookieDate);
			}
			
		   
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
		}

		
	} 
	
	
	
	
	
	
	
	
	
	

	/**
	 * This method perfrom deletion of the user account when called 
	 * @param username of the user
	 * @return integer 
	 */
	public int deleteUserInfo(String username) {
		try (Connection con = getConnection()) {
	       
	        try (PreparedStatement st1 = con.prepareStatement(Stringutils.QUERY_DELETE_USER_EXPENSES)) {
	            st1.setString(1, username);
	            st1.executeUpdate();
	        }

	        
	        try (PreparedStatement st2 = con.prepareStatement(Stringutils.QUERY_DELETE_USER_INCOMES)) {
	            st2.setString(1, username);
	            st2.executeUpdate();
	        }

	   
	        try (PreparedStatement st3 = con.prepareStatement(Stringutils.QUERY_DELETE_USER)) {
	            st3.setString(1, username);
	            return st3.executeUpdate();
	        }
		}catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	
	
	}
}


