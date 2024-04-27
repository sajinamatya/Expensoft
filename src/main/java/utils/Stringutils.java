package utils;

public class Stringutils {

	// Start: Database Connection
		public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/expensoft";
		public static final String LOCALHOST_USERNAME = "root";
		public static final String LOCALHOST_PASSWORD = "";
		// End: Database Connection

		// Start: SQl Queries
		public static final String QUERY_SIGNUP_USER = "INSERT INTO user ("
				+ "full_name, email, date_of_birth, gender,phone_number, address, user_name, password,security_question) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
		public static final String QUERY_USER_EXPENSE = "INSERT INTO expense ("
				+ "user_id, expense_amount, expense_date,expense_category, expense_description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		public static final String QUERY_USER_INCOME = "INSERT INTO income ("
				+ "user_id, income_amount, income_date,income_category, income_description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM user WHERE user_name = ?";
		public static final String QUERY_GET_ALL_USER = "SELECT * FROM user";
		public static final String QUERY_CHECK_EMAIL = " SELECT email FROM user WHERE email = ?";
		public static final String QUERY_CHECK_PHONENUMBER = " SELECT phone_number FROM user WHERE phone_number = ?";
		public static final String QUERY_CHECK_USERNAME = "SELECT user_name FROM user WHERE user_name = ?";
		public static final String QUERY_GET_USER_ID = "SELECT user_id FROM user WHERE user_name = ?";
		public static final String QUERY_DELETE_USER = " DELETE FROM user where user_id = ?";
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
	

		// Login Page Messages
		public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
		public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
		public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

		// Other Messages
		public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

		public static final String MESSAGE_SUCCESS = "successMessage";
		public static final String MESSAGE_ERROR = "errorMessage";
		// End: Validation Messages

		// Start: JSP Route path 
		public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
		public static final String PAGE_URL_SIGNUP = "/pages/signup.jsp";
		public static final String PAGE_URL_USER_HOME = "/pages/userhome.jsp";
		public static final String PAGE_URL_HEADER = "/pages/header.jsp" ;
		public static final String PAGE_URL_ADMIN = "/pages/admindashboard.jsp" ;
		// End: JSP Route

		// Start: Servlet Route Path
		public static final String SERVLET_URL_LOGIN = "/login";
		public static final String SERVLET_URL_SIGNUP = "/signup";
		public static final String SERVLET_URL_LOGOUT = "/logout";
		public static final String SERVLET_URL_EXPENSE = "/expense";
		public static final String SERVLET_URL_INCOME = "/income";
		// End: Servlet Route Path

		// Start: NormalText
		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		
		// End: Normal Text
}
