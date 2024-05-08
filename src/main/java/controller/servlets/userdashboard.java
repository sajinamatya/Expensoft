package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.ExpenseModel;
import model.IncomeModel;

import utils.Stringutils;

/**
 * Servlet implementation class userdashboard
 */
@WebServlet(asyncSupported = true, urlPatterns = { Stringutils.SERVLET_URL_USER_DASHBOARD})
public class userdashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController controller = new DatabaseController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession(false);
		int userId = Integer.parseInt((String) userSession.getAttribute("user_id"));
		
		ArrayList<ExpenseModel> expense = controller.getAllExpenseUserInfo(userId);
		request.setAttribute("expenseList", expense);
		
		ArrayList<IncomeModel> income = controller.getAllIncomeUserInfo(userId);
		request.setAttribute("incomeList", income); 
		
		double totalincome = controller.getTotalIncomeOfUser(userId);
		request.setAttribute("totalincome", totalincome);
		
		double totalexpense = controller.getTotalExpenseOfUser(userId);
		request.setAttribute("totalexpense", totalexpense);
		
		Map<String, Double> ExpenseMap = controller.getCategoryExpenseOfUser(userId);
		request.setAttribute("expenseCategory",ExpenseMap);
		
		Map<String, Double> IncomeMap = controller.getCategoryIncomeOfUser(userId);
		request.setAttribute("incomeCategory",IncomeMap);
		
		
		
		request.getRequestDispatcher(Stringutils.PAGE_URL_USERDASHBOARD).forward(request, response);
	}
}