<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%String contextPath = request.getContextPath();%>
    <%@page import="utils.Stringutils"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/index.css" />
</head>
<body>
<div class = "main">

<img class ='logo' src ="<%=contextPath%>/resources/images/Userinterface/expensoft.png" height=120 width = 120>
	<div  class ='mainback'></div>
	<div class='submain'>
	<div class='text'>
	<h1 class='main-heading'> Welcome to Expensoft </h1>
	<h2 class = "sub-heading "> The platform where you can track your expenses<br> and income for better saving decision</h2>
	</div>
	
	<div class ="text-2">
	<p> Lets starts the journey to<br> track our expense and income </p>
	<a href ="<%=contextPath%>/pages/signup.jsp" ><button>Register</button></a>
    <a href ="<%=contextPath%>/pages/login.jsp" ><button>Login</button></a>
	</div>
	
	
	
	
	
	</div>
</div>
</body>
</html>