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
import model.IncomeModel;

import utils.Stringutils;

/**
 * Servlet implementation class incomeServlet
 */
@WebServlet(urlPatterns = Stringutils.SERVLET_URL_INCOME, asyncSupported = true)
public class IncomeServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;

    public IncomeServlet() {
        this.DatabaseController = new DatabaseController();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    	
    	float income_amount = Float.parseFloat(request.getParameter(Stringutils.INCOME_AMOUNT));
    	String income_category = request.getParameter(Stringutils.INCOME_CATEGORY);
    	LocalDate  income_date = LocalDate.parse(request.getParameter(Stringutils.INCOME_DATE));
    	String income_description = request.getParameter(Stringutils.INCOME_DESCRIPTION);
    	
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
    	
    	IncomeModel income = new IncomeModel(user_id ,income_amount, income_date, income_category, income_description);
    	int incomeResult = DatabaseController.userIncome(income);
    	if (incomeResult == 1 ) {
    		request.getRequestDispatcher(Stringutils.PAGE_URL_USER_HOME).forward(request, response);
    	}
    }

}


