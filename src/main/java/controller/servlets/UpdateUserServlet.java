package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.UserModel;
import utils.Stringutils;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(urlPatterns = Stringutils.SERVLET_URL_UPDATE, asyncSupported = true)
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController databaseController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if updating the data is performed 
		
				if( request.getParameter("update") != null) {
				
				
					String fullName = request.getParameter(Stringutils.FULL_NAME);
					String email = request.getParameter(Stringutils.EMAIL);
					String username = request.getParameter(Stringutils.USERNAME);
					String newusername = request.getParameter("newuserName");
//					LocalDate dateOfBirth = LocalDate.parse(request.getParameter(Stringutils.DATE_OF_BIRTH));
				
					String phoneNumber = request.getParameter(Stringutils.PHONE_NUMBER);
					String address = request.getParameter(Stringutils.ADDRESS);
					int user_id = databaseController.extractUser_Id(username);
					UserModel user1 = new UserModel(fullName,email,newusername,phoneNumber,address);
					
					int updateResult = databaseController.updateUserProfile(user1, user_id);
					if(updateResult == 1 ) {
						response.sendRedirect(request.getContextPath() + Stringutils.SERVLET_URL_ADMIN_HOME );
					}
	}
	}
}
