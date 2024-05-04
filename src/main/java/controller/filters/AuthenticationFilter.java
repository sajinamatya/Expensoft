package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Stringutils;

public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {

	    // Cast request and response objects to HttpServletRequest and HttpServletResponse for type safety
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;

	    // Get the requested URI
	    String uri = req.getRequestURI();

	    // Allow access to static resources (CSS) and the index page without checking login
	    if (uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith(".jpg")) {
	        chain.doFilter(request, response);
	        return;
	    }
	    
//	    if(uri.endsWith(Stringutils.URL_INDEX) || uri.endsWith("/")) {
//			request.getRequestDispatcher(Stringutils.SERVLET_URL_HOME).forward(request, response);
////	        res.sendRedirect(req.getContextPath() + Stringutils.SERVLET_URL_HOME);
//	        return;
//    	}

	    // Separate flags for login, login/logout servlets, and register page/servlet for better readability
	    boolean isLogin = uri.endsWith(Stringutils.PAGE_URL_LOGIN);
	    boolean isLoginServlet = uri.endsWith(Stringutils.SERVLET_URL_LOGIN);
	    
	    boolean isLogoutServlet = uri.endsWith(Stringutils.SERVLET_URL_LOGOUT);
	    
	    boolean isAdminHomeServlet = uri.endsWith(Stringutils.SERVLET_URL_ADMIN_HOME);
	    boolean isAdminHome = uri.endsWith(Stringutils.PAGE_URL_ADMIN_HOME);
	    
	    boolean isProfile = uri.endsWith(Stringutils.PAGE_URL_PROFILE);
	    boolean isProfileServlet = uri.endsWith(Stringutils.SERVLET_URL_PROFILE);
	    
	    boolean isExpenseServlet = uri.endsWith(Stringutils.SERVLET_URL_EXPENSE);
	    boolean isIncomeServlet = uri.endsWith(Stringutils.SERVLET_URL_INCOME);
	    boolean isModifyUserServlet = uri.endsWith(Stringutils.SERVLET_URL_MODIFY_USER);
	    boolean isSignupPage = uri.endsWith(Stringutils.PAGE_URL_SIGNUP);
	    boolean isSignupervlet = uri.endsWith(Stringutils.SERVLET_URL_SIGNUP);
	    boolean isUserHome = uri.endsWith(Stringutils.PAGE_URL_USER_HOME);
	    // Check if a session exists and if the username attribute is set to determine login status
	    HttpSession session = req.getSession(false); // Don't create a new session if one doesn't exist
	    boolean isLoggedIn = session != null && session.getAttribute(Stringutils.USERNAME) != null;

	    // Redirect to login if user is not logged in and trying to access a protected resource
	    if (!isLoggedIn && (isAdminHomeServlet || isAdminHome  || isSignupervlet)) {
	        res.sendRedirect(req.getContextPath() + Stringutils.PAGE_URL_LOGIN);
	    } else if (isLoggedIn && !isUserHome && !(!isLogin || isLogoutServlet)) { // Redirect logged-in users to the index page if trying to access login page again
	        res.sendRedirect(req.getContextPath() + Stringutils.PAGE_URL_INDEX);
	    } else {
	        // Allow access to the requested resource if user is logged in or accessing unprotected resources
	        chain.doFilter(request, response);
	    }

	}

	@Override
	public void destroy() {
	}
}
