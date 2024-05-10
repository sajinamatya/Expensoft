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
 * Servlet implementation class ModifyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = Stringutils.SERVLET_URL_MODIFY_USER)
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController dbController;

	public ModifyUserServlet() {
		this.dbController = new DatabaseController();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = request.getParameter(Stringutils.UPDATE_ID);
		String deleteId = request.getParameter(Stringutils.DELETE_ID);

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserModel usermodel = dbController.getAllUserInfoByUsername(req.getParameter(Stringutils.UPDATE_ID)) ;
			
			req.setAttribute("usermodel",usermodel );
			req.getRequestDispatcher( Stringutils.PAGE_URL_USERUPDATE).forward(req, resp);
			
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");
		if (dbController.deleteUserInfo(req.getParameter(Stringutils.DELETE_ID)) == 1) {
			req.setAttribute(Stringutils.MESSAGE_SUCCESS, Stringutils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + Stringutils.SERVLET_URL_ADMIN_HOME);
		} else {
			req.setAttribute(Stringutils.MESSAGE_ERROR, Stringutils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + Stringutils.SERVLET_URL_ADMIN_HOME);
		}
	}

}