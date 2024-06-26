package utils;

import java.io.File;

public class Stringutils {

	// Start: Database Connection
		public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/expensoft";
		public static final String LOCALHOST_USERNAME = "root";
		public static final String LOCALHOST_PASSWORD = "";
		// End: Database Connection

		// Start: SQl Queries
		public static final String QUERY_SIGNUP_USER = "INSERT INTO user ("
				+ "full_name, email, date_of_birth, gender,phone_number, address, user_name, password,security_question,image) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		public static final String QUERY_USER_EXPENSE = "INSERT INTO expense ("
				+ "user_id, expense_amount, expense_date,expense_category, expense_description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		public static final String QUERY_USER_INCOME = "INSERT INTO income ("
				+ "user_id, income_amount, income_date,income_category, income_description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		public static final String QUERY_USER_CHECK = "SELECT * FROM user WHERE user_name = ?";
		public static final String QUERY_USER_CHECKPASSWORD = "SELECT username,password FROM user WHERE user_name = ?";
		public static final String QUERY_GET_ALL_USER = "SELECT * FROM user where user_name  != 'admin'";
		public static final String QUERY_USER_BY_ID = "SELECT * FROM user where user_name= ?";
		public static final String QUERY_GET_ALL_INCOME= "SELECT * FROM income WHERE user_id=? ";
		public static final String QUERY_GET_ALL_EXPENSE= "SELECT * FROM expense WHERE user_id=? ";
		public static final String QUERY_CHECK_EMAIL = " SELECT email FROM user WHERE email = ?";
		public static final String QUERY_CHECK_PHONENUMBER = " SELECT phone_number FROM user WHERE phone_number = ?";
		public static final String QUERY_CHECK_USERNAME = "SELECT user_name FROM user WHERE user_name = ?";
		public static final String QUERY_GET_USER_ID = "SELECT user_id FROM user WHERE user_name = ?";
		public static final String QUERY_DELETE_USER = " DELETE FROM user where user_name = ?";
		public static final String QUERY_DELETE_USER_EXPENSES = "DELETE FROM expense WHERE user_id = (SELECT user_id FROM user WHERE user_name = ?)";
		public static final String QUERY_DELETE_USER_INCOMES = "DELETE FROM income WHERE user_id = (SELECT user_id FROM user WHERE user_name = ?)";
		public static final String QUERY_UPDATE_USER_PROFILE = "UPDATE user SET full_name = ?, email = ?, phone_number = ?, address = ?, user_name = ? WHERE user_id = ?";
		public static final String QUERY_USER_PASSWORD_CHECK = "SELECT user_id,password FROM user WHERE user_id = ? AND password = ?";
		public static final String QUERY_USER_PASSWORD_UPDATE = "UPDATE user SET password = ? WHERE user_name = ?";
		public static final String QUERY_TOTAL_INCOME = "SELECT SUM(income_amount) as total_income FROM income WHERE user_id= ?";
		public static final String QUERY_TOTAL_EXPENSE = "SELECT SUM(expense_amount) as total_expense FROM expense WHERE user_id= ?";
		public static final String QUERY_EXPENSE_CATEGORY = "SELECT expense_category, SUM(expense_amount) AS total_expense FROM expense WHERE user_id = ? GROUP BY expense_category ORDER BY total_expense DESC LIMIT 1 ";
		public static final String QUERY__INCOME_CATEGORY = "SELECT income_category, SUM(income_amount) AS total_income FROM income WHERE user_id = ? GROUP BY income_category ORDER BY total_income DESC LIMIT 1 ";
		public static final String QUERY_TOTAL_USER = " SELECT count(*) as totaluser FROM user WHERE user_name<>'admin'";
		public static final String QUERY_TOTAL_EXPENSE_ENTRY = "SELECT count(*) as totalnoexpense from expense ";
		public static final String QUERY_TOTAL_INCOME_ENTRY = "SELECT count(*) as totalnoincome from income ";
		public static final String QUERY_USER_MOST_EXPENSE = "SELECT us.user_id, us.user_name, SUM(expense_amount) AS highest_expense FROM user us JOIN expense ex ON us.user_id = ex.user_id GROUP BY us.user_id, us.user_name ORDER BY highest_expense DESC LIMIT 1;";
		public static final String QUERY_USER_MOST_INCOME = "SELECT us.user_id, us.user_name, SUM(income_amount) AS highest_income FROM user us JOIN income ex ON us.user_id = ex.user_id GROUP BY us.user_id, us.user_name ORDER BY highest_income DESC LIMIT 1;";
		// End: SQl Queries

		// Start: Parameter names
		public static final String USERNAME = "userName";
		public static final String FULL_NAME = "fullName";
		public static final String ADDRESS = "address";
		public static final String SECURITY_QUESTION = "securityQn";
		public static final String DATE_OF_BIRTH = "dateOfBirth";
		public static final String GENDER = "gender";
		public static final String EMAIL = "email";
		public static final String PHONE_NUMBER = "phoneNumber";
		public static final String PASSWORD = "password";
		public static final String NEW_PASSWORD = "newpassword";
		public static final String RETYPE_PASSWORD = "retypePassword";
		public static final String USER_NAME = "user_name";
		public static final String  USER_ID = "user_id";
		
		public static final String EXPENSE_AMOUNT = "expenseAmount";
		public static final String EXPENSE_CATEGORY = "expenseCategory";
		public static final String EXPENSE_DATE = "expenseDate";
		public static final String EXPENSE_DESCRIPTION = "expenseDesc";
		
		public static final String INCOME_AMOUNT = "incomeAmount";
		public static final String INCOME_CATEGORY = "incomeCategory";
		public static final String INCOME_DATE = "incomeDate";
		public static final String INCOME_DESCRIPTION = "incomeDesc";
		
		// End: Parameter names

		// Start: Validation Messages
		// Register Page Messages
		public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
		public static final String MESSAGE_ERROR_SIGNUP = "Please correct the form data.";
		public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
		public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
		public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
		public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
		public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";
		public static final String MESSAGE_ERROR_PASSWORD= "Password didn't matched ";

		// Login Page Messages
		public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
		public static final String MESSAGE_SUCCESS_PASSWORD = "Successfully Changed Password!";
		public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
		public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";
		public static final String MESSAGE_SUCCESS_PROFILE = "Sucessfully Updated Profile!";
		// Other Messages
		public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
		public static final String MESSAGE_ERROR_PROFILE = "Fail to update your profile";
		public static final String MESSAGE_SUCCESS = "successMessage";
		public static final String MESSAGE_ERROR = "errorMessage";
		// End: Validation Messages

		// Start: JSP Route path 
		public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
		public static final String PAGE_URL_SIGNUP = "/pages/signup.jsp";
		public static final String PAGE_URL_USER_HOME = "/pages/userhome.jsp";
		public static final String PAGE_URL_HEADER = "/pages/header.jsp" ;
		public static final String PAGE_URL_FOOTER = "/pages/footer.jsp" ;
		public static final String PAGE_URL_ADMIN = "/pages/admindashboard.jsp" ;
		public static final String PAGE_URL_ADMIN_HOME = "/pages/adminhome.jsp" ;
		public static final String PAGE_URL_PROFILE = "/pages/profilepage.jsp" ;
		public static final String PAGE_URL_INDEX =  "/index.jsp";
		public static final String PAGE_URL_USERDASHBOARD =  "/pages/userhomedashboard.jsp";
		public static final String PAGE_URL_USERUPDATE =  "/pages/updateuser.jsp";
		// End: JSP Route

		// Start: Servlet Route Path
		public static final String SERVLET_URL_ADMIN_HOME = "/adminhome";
		public static final String SERVLET_URL_ADMIN_ADD = "/adminadd";
		public static final String SERVLET_URL_USER_DASHBOARD = "/userdashboard";
		public static final String SERVLET_URL_ADMIN_DASHBOARD = "/admindashboard";
		public static final String SERVLET_URL_LOGIN = "/login";
		public static final String SERVLET_URL_SIGNUP = "/signup";
		public static final String SERVLET_URL_LOGOUT = "/logout";
		public static final String SERVLET_URL_EXPENSE = "/expense";
		public static final String SERVLET_URL_INCOME = "/income";
		public static final String SERVLET_URL_MODIFY_USER= "/modify";
		public static final String SERVLET_URL_PROFILE = "/profile";
		public static final String SERVLET_URL_UPDATE = "/update";
		// End: Servlet Route Path

		// Start: NormalText
		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String USER_LIST = "userList";
		public static final String DELETE_ID= "delete";
		public static final String UPDATE_ID= "update";
		// End: Normal Text
		
		
		// start : part file 
		public static final String IMAGE_DIR = "xampp\\tomcat\\webapps\\images\\";
		public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR;
		
		public static final String IMAGE_ROOT_PATH = "Users\\LENOVO\\Expensoft\\src\\main\\webapp\\resources\\images\\";
		public static final String IMAGE_DIR_USER = "C:/" + IMAGE_ROOT_PATH + "User\\";
				
		
		
		// end : part file 
}
