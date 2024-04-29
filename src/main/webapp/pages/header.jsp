
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="utils.Stringutils"%>
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(Stringutils.USERNAME);
    String contextPath = request.getContextPath();
%>


<div id="header">
    <header class="header">
       
        <ul class="main-nav">
            <li><a href="#"><img alt="" src="<%=contextPath %>/resources/home_icon.svg" width = 30 height= 30></a></li>
            <li><a href="#"><img alt="" src="<%=contextPath %>/resources/dashboard.svg" width = 30 height= 30></a></li>
            <li class="profile"><a href="#"><img alt="" src="<%=contextPath %>/resources/profile.svg" width = 30 height= 30></a></li>
           
            <li>
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + Stringutils.SERVLET_URL_LOGOUT);
                    } else {
                        out.print(contextPath + Stringutils.PAGE_URL_LOGIN);
                    }
                %>" method="post">
                
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(Stringutils.LOGOUT);
                        } else {
                            out.print(Stringutils.LOGIN);
                        }
                    %>"/>

                </form>
                
            </li>
            
        </ul>
    </header>
</div>
