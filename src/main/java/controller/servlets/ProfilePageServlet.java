package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		String fullName = request.getParameter(Stringutils.FULL_NAME);
		String email = request.getParameter(Stringutils.EMAIL);
		String username = request.getParameter(Stringutils.USERNAME);
//		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(Stringutils.DATE_OF_BIRTH));
		
		String phoneNumber = request.getParameter(Stringutils.PHONE_NUMBER);
		String address = request.getParameter(Stringutils.ADDRESS);
		
//		Part imagePart = request.getPart("image");	
		
		UserModel user1 = new UserModel(fullName,email,username,phoneNumber,address);
		HttpSession userSession = request.getSession(false);
		if (userSession != null && userSession.getAttribute("user_id") != null) {
		    // Get the user_id attribute from the session and parse it to an integer
		    int userId = Integer.parseInt((String) userSession.getAttribute("user_id"));

		    // Call the updateUserProfile method with the user object and user_id
		    int updateResult = databaseController.updateUserProfile(user1, userId);
		} else {
		   // redirect to the login page if the user is not loggged in 
			
			response.sendRedirect(request.getContextPath() + Stringutils.PAGE_URL_LOGIN );
		}
		
		
			
		}

}
