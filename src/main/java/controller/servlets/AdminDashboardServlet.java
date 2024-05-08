package controller.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;


import utils.Stringutils;

/**
 * Servlet implementation class userdashboard
 */
@WebServlet(asyncSupported = true, urlPatterns = { Stringutils.SERVLET_URL_ADMIN_DASHBOARD})
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controller = new DatabaseController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totaluser = controller.getTotalNoOfUser();
		
		request.setAttribute("TotalUser",totaluser);
		
		
		
		
		request.getRequestDispatcher(Stringutils.PAGE_URL_ADMIN).forward(request, response);
	}
}  