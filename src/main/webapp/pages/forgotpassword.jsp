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
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/forgotpassword.css"/>
</head>
<body>
<div class= "forgot-main">

	<div class="forgot-left"> <img alt="" src="<%=contextPath%>/resources/forgot_image.jpg" width=600 height=500>
	</div>
	
	<div class ="forgot-right">
		<h1> Forgot Password </h1>
		<form action="<%= contextPath%>/forgot" method="POST"  >
			
			<input type="text" id="name" name = 'forgotsecurity' placeholder ="Username" required>
	
			<input type="password" id="newpassword" name ='newpassword' placeholder="New Password" required>
			<input type="password" id="re-newpassword" name ='re-newpassword' placeholder=" Re type New Password" required>
			<input type="submit" name="" value="Submit">
			
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