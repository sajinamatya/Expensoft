package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.LoginModel;
import utils.Stringutils;

/**
 * This Servlet class handles login requests for a student management system.
 * It retrieves username and password from the login form submission,
 * validates them against a database using a `DBController`, and redirects the user
 * accordingly based on the login result.
 *
 * @author [Prithivi Maharjan, prithivi.maharjan18@gmail.com]
 */

@WebServlet(urlPatterns = Stringutils.SERVLET_URL_LOGIN, asyncSupported = true)
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;

    public Login() {
        this.DatabaseController = new DatabaseController();
    }

    /**
     * Handles HTTP POST requests for login.
     *
     * @param request The HttpServletRequest object containing login form data.
     * @param response The HttpServletResponse object for sending responses.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract username and password from the request parameters
        String userName = request.getParameter(Stringutils.USERNAME);
        String password = request.getParameter(Stringutils.PASSWORD);
        String user_id = String.valueOf(DatabaseController.extractUser_Id(userName));
        // Create a LoginModel object to hold user credentials
        LoginModel loginModel = new LoginModel(userName, password);
        
        // Call DBController to validate login credentials
        int loginResult = DatabaseController.getUserLoginInfo(loginModel);

        // Handle login results with appropriate messages and redirects
        if (loginResult == 1) {
            // Login successful
        	
        	HttpSession userSession = request.getSession();
			userSession.setAttribute(Stringutils.USERNAME, userName);
			userSession.setAttribute(Stringutils.USER_ID, user_id);
			userSession.setMaxInactiveInterval(30*60);
			
			Cookie userCookie= new Cookie(Stringutils.USER, userName);
			Cookie userCookieId = new Cookie("user_id",user_id);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			response.addCookie(userCookieId);
			
			
			
            request.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_LOGIN);
			response.sendRedirect(request.getContextPath() + Stringutils.PAGE_URL_USER_HOME);
			}
		else if(loginResult == 3 ) {
			HttpSession userSession = request.getSession();
			userSession.setAttribute(Stringutils.USERNAME, userName);
			userSession.setMaxInactiveInterval(30*60);
			
			Cookie userCookie= new Cookie(Stringutils.USER, userName);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
			request.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_LOGIN);
			response.sendRedirect(request.getContextPath() + Stringutils.SERVLET_URL_ADMIN_HOME); 
			}
         else if (loginResult == 0) {
            // Username or password mismatch
            request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_LOGIN);
			request.setAttribute(Stringutils.USERNAME, userName);
            request.getRequestDispatcher(Stringutils.PAGE_URL_LOGIN).forward(request, response);
        } else if (loginResult == -1) {
            // Username not found
            request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_CREATE_ACCOUNT);
			request.setAttribute(Stringutils.USERNAME, userName);
            request.getRequestDispatcher(Stringutils.PAGE_URL_LOGIN).forward(request, response);
        } else {
            // Internal server error
            request.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils. MESSAGE_ERROR_SERVER);
			request.setAttribute(Stringutils.USERNAME, userName);
            request.getRequestDispatcher(Stringutils.PAGE_URL_LOGIN).forward(request, response);
        }
        
       
        
        
    }
    
}

