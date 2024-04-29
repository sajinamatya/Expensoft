<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.Stringutils"%>
    <%
String contextPath = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Header.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Adminhome.css" />
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />
</body>
<h1>User Information </h1>
<c:if test="${empty userList}">
				<p>No User found.</p>
</c:if>
    <table>
        <tr>
            <th></th>
            <th>Full Name </th>
            <th>Email</th>
            <th>User name </th>
        </tr>
        <c:if test="${not empty userList}">
	<c:forEach items="${userList}" var="users">
            <tr>
                <td>${users.gender}</td>
                <td>${users.fullName}</td>
                <td>${users.email}</td>
                <td>${users.userName}</td>
                   
                
            </tr>
        </c:forEach>
        </c:if>
    </table>

</html>