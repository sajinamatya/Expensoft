<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String contextPath = request.getContextPath();
%>
<%@page import="model.UserModel"%>
<%@page import="utils.Stringutils"%>
<%
    UserModel usermodel = (UserModel) request.getAttribute("usermodel"); // Assuming userModel is set in request scope
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/Header.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/footer.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/updateuser.css" />
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>"/>
<form action="<%=contextPath + Stringutils.SERVLET_URL_UPDATE%>" method="POST"  >
			
			<label for="email">Email </label><br>
<input type="text" id="email" name="email" value="<%= usermodel.getEmail() %>"><br>

<label for="phone">Phone Number </label><br>
<input type="text" id="phone" name="phoneNumber" value="<%= usermodel.getPhoneNumber() %>"><br>

<label for="fullname">Full Name </label><br>
<input type="text" id="fullName" name="fullName" value="<%= usermodel.getFullName() %>"><br>

<label for="userName">User Name </label><br>
<input type="hidden" id="name" name="userName" value="<%= usermodel.getUserName() %>">
<input type="text" id="name" name="newuserName" value="<%= usermodel.getUserName() %>"><br>


<label for="address">Address</label><br>
<input type="text" id="address" name="address" value="<%= usermodel.getAddress() %>"><br>
<input type="submit" name="update" value="Update user"><br>
			</form>
			<jsp:include page="<%=Stringutils.PAGE_URL_FOOTER%>" />
</body>

</html>