<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%
String contextPath = request.getContextPath();
%>
<%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Header.css" />
<meta charset="ISO-8859-1">
<title>admin</title>
</head>
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />
</body>
</html>