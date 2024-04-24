package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.database.DatabaseController;
import model.SignupModel;

import utils.Stringutils;



/**
 * Servlet implementation class SignUp
 */
@WebServlet(urlPatterns = Stringutils.SERVLET_URL_SIGNUP, asyncSupported = true)
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController databaseController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
    	// instantiate the object of DatabaseController 
    	this.databaseController = new DatabaseController();
        
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Extract student information from request parameters
		String fullName = request.getParameter(Stringutils.FULL_NAME);
		String email = request.getParameter(Stringutils.EMAIL);
		String username = request.getParameter(Stringutils.USERNAME);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(Stringutils.DATE_OF_BIRTH));
		String gender = request.getParameter(Stringutils.GENDER);
		String phoneNumber = request.getParameter(Stringutils.PHONE_NUMBER);
		String address = request.getParameter(Stringutils.ADDRESS);
		String securityQn = request.getParameter(Stringutils.SECURITY_QUESTION);
		String password = request.getParameter(Stringutils.PASSWORD);
		
		
		if(databaseController.checkEmailIfExists(email) == true || databaseController.checkNumberIfExists(phoneNumber) == true || databaseController.checkUsernameIfExists(username)== true) {
			request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_EMAIL);
			request.getRequestDispatcher(Stringutils.PAGE_URL_SIGNUP).forward(request, response);
			
		}
		else {

			// Creating  a Sign up model  object to hold user details
			SignupModel user = new SignupModel(fullName,email,username,gender,phoneNumber,address,password,securityQn,dateOfBirth);
		
		

		// Calling DatabaseController to sign up  the user 
			int result = databaseController.signupUser(user);

			if (result == 1) {
				request.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_REGISTER);
				response.sendRedirect(request.getContextPath() + Stringutils.PAGE_URL_LOGIN + "?success=true");
		} 	else if (result == 0) {
				request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_SIGNUP);
				request.getRequestDispatcher(Stringutils.PAGE_URL_SIGNUP).forward(request, response);
		} 	else {
				request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_SERVER);
				request.getRequestDispatcher(Stringutils.PAGE_URL_SIGNUP).forward(request, response);
		}
	}

		
}
}
