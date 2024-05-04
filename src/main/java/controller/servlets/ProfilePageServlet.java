package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import model.UserModel;
import utils.Stringutils;

/**
 * Servlet implementation class ProfilePageServlet
 */
@WebServlet(urlPatterns = Stringutils.SERVLET_URL_PROFILE, asyncSupported = true)
public class ProfilePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController databaseController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if updating the data is performed 
		if( request.getParameter("save") != null) {
		
		
			String fullName = request.getParameter(Stringutils.FULL_NAME);
			String email = request.getParameter(Stringutils.EMAIL);
			String username = request.getParameter(Stringutils.USERNAME);
//			LocalDate dateOfBirth = LocalDate.parse(request.getParameter(Stringutils.DATE_OF_BIRTH));
		
			String phoneNumber = request.getParameter(Stringutils.PHONE_NUMBER);
			String address = request.getParameter(Stringutils.ADDRESS);
			
//			Part imagePart = request.getPart("image");	
		
			UserModel user1 = new UserModel(fullName,email,username,phoneNumber,address);
			HttpSession userSession = request.getSession(false);
			if (userSession != null && userSession.getAttribute("user_id") != null) {
		    // Get the user_id attribute from the session and parse it to an integer
				int userId = Integer.parseInt((String) userSession.getAttribute("user_id"));

		    // Call the updateUserProfile method with the user object and user_id
				int updateResult = databaseController.updateUserProfile(user1, userId);
				if(updateResult == 1 ){
					// updating session after profile update.
					HttpSession session = request.getSession(true);
					session.setAttribute(Stringutils.USERNAME, username);
					session.setAttribute("email", email);
					session.setAttribute("address", address);
					session.setAttribute("phone", phoneNumber);
					session.setAttribute("fullname", fullName);
					session.setMaxInactiveInterval(30*60);
					// updating cookie after profile update.
					Cookie userCookie= new Cookie(Stringutils.USER, username);
					Cookie userCookieEmail = new Cookie("email", email);
					Cookie userCookiePhone = new Cookie("phonenumber",phoneNumber);
					userCookie.setMaxAge(30*60);
					response.addCookie(userCookie);
					response.addCookie(userCookieEmail);
					response.addCookie(userCookiePhone);
				
					request.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_PROFILE);
					request.getRequestDispatcher(Stringutils.PAGE_URL_PROFILE).forward(request, response);
				}
				else {
					request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_PROFILE);
					request.getRequestDispatcher(Stringutils.PAGE_URL_PROFILE).forward(request, response);
				} 
			} 
			else {
		   // redirect to the login page if the user is not logged in 
			
				response.sendRedirect(request.getContextPath() + Stringutils.PAGE_URL_LOGIN );
		}
		
		}
		// if the reset password functionality is performed 
		else if (request.getParameter("updatepassword") != null) {
			String oldpassword = request.getParameter(Stringutils.PASSWORD);
			String newpassword = request.getParameter(Stringutils.NEW_PASSWORD);
			HttpSession userSession = request.getSession(false);
			if (userSession != null) {
		    // Get the user_name attribute from the session and parse it to an integer
				String user_name = (String) userSession.getAttribute(Stringutils.USERNAME);
				
		    // Call the updateUserProfile method with the user object and user_name
				int changeResult = databaseController.changePassword(newpassword,oldpassword,user_name);
				
				if(changeResult == 1 ) {
					request.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_PASSWORD);
					request.getRequestDispatcher(Stringutils.PAGE_URL_PROFILE).forward(request, response);
				}
				else if ( changeResult == -1 ) {
					request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_PASSWORD);
					request.getRequestDispatcher(Stringutils.PAGE_URL_PROFILE).forward(request, response);
				}
				else {
					
				}
			} 
			else {
				response.sendRedirect(request.getContextPath() + Stringutils.PAGE_URL_LOGIN );
		}
		}
			
		}

}
