package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.ExpenseModel;
import utils.Stringutils;

/**
 * Servlet implementation class ExpenseServlet
 */
@WebServlet(urlPatterns = Stringutils.SERVLET_URL_EXPENSE, asyncSupported = true)
public class ExpenseServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;

    public ExpenseServlet() {
        this.DatabaseController = new DatabaseController();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    	
    	float expense_amount = Float.parseFloat(request.getParameter(Stringutils.EXPENSE_AMOUNT));
    	String expense_category = request.getParameter(Stringutils.EXPENSE_CATEGORY);
    	LocalDate  expense_date = LocalDate.parse(request.getParameter(Stringutils.EXPENSE_DATE));
    	String expense_description = request.getParameter(Stringutils.EXPENSE_DESCRIPTION);
    	
    	Cookie[] cookies = request.getCookies();
        String userIdString = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    userIdString = cookie.getValue();
                    break;
                }
            }
        }
    	int user_id = Integer.parseInt(userIdString);
    	
    	ExpenseModel expense = new ExpenseModel(user_id ,expense_amount, expense_date, expense_category, expense_description);
    	int expenseResult = DatabaseController.userExpense(expense);
    	if (expenseResult == 1 ) {
    		request.getRequestDispatcher(Stringutils.PAGE_URL_USER_HOME).forward(request, response);
    	}
    }

}