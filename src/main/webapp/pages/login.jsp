<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
String contextPath = request.getContextPath();
%>
<%@page import="utils.Stringutils"%>
<%

String errMsg = (String) request.getAttribute(Stringutils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(Stringutils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(Stringutils.USERNAME);
String successParam = request.getParameter(Stringutils.SUCCESS);
String user_id = (String) request.getAttribute(Stringutils.USER_ID);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/login.css"/>
</head>
<body>
<div class= "login-main">

	<div class="login-left"> <img alt="" src="<%=contextPath%>/resources/image1.jpg" width=600 height=500>
	</div>
	
	<div class ="login-right">
		<h1> Login </h1>
		<form action="<%= contextPath%>/login" method="POST"  >
			
			<input type="text" id="name" name = 'userName' placeholder ="Username" required>
	
			<input type="password" id="password" name ='password' placeholder="Password" required>
			
			<input type="submit" name="" value="Login">
			<p>Don't have an account? <a href="<%=contextPath%>/pages/signup.jsp">Signup</a><p>
<%
		if (errMsg != null) {
			// print
		%>
		<h6 class="error">
			<%
			out.println(errMsg);
			%>
		</h6>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h6 class="success">
			<%
			out.println(successMsg);
			%>
		</h6>
		<%
		}
		%>
		</form>
		
	</div>

</div>



</body>
</html>