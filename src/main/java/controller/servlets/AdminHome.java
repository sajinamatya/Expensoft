package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.UserModel;
import utils.Stringutils;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { Stringutils.SERVLET_URL_ADMIN_HOME })
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controller = new DatabaseController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserModel> user = controller.getAllUserInfo();
		request.setAttribute("userList", user);
		request.getRequestDispatcher(Stringutils.PAGE_URL_ADMIN_HOME).forward(request, response);
	}
}
