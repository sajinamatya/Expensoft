<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
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

	<div class="login-left"> <img alt="" src="../resources/image1.jpg">
	</div>
	
	<div class ="login-right">
		<h1> Login </h1>
		<form action="sajin.html" method="POST" onsubmit="return validate()" >
			
			<input type="text" id="name"placeholder ="Username" required>
	
			<input type="password" id="password" placeholder="Password" required>
			
			<input type="submit" name="" value="Login">
			<p>Don't have an account? <a href="<%=contextPath%>/pages/signup.jsp">Signup</a><p>

		</form>
		
	</div>

</div>



</body>
</html>