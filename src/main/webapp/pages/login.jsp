<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/login.css"/>
</head>
<body>
<div class= "login-main">

	<div class="login-left"></div>
	
	<div class ="login-right">
		<h1> Login </h1>
		<form action="sajin.html" method="POST" onsubmit="return validate()" >
			
			<input type="text" id="name"placeholder ="Username">
	
			<input type="password" id="password" placeholder="Password">
			<input type="submit" name="" value="Login">
		

		</form>
	</div>

</div>



</body>
</html>