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

<h1>User Information </h1>
<c:if test="${empty userList}">
				<p>No User found.</p>
</c:if>
    <table>
        <tr>
            <th>Gender</th>
            <th>Full Name </th>
            <th>Email</th>
            <th>User name </th>
            <th>Address </th>
            <th> Action </th>
        </tr>
        <c:if test="${not empty userList}">
	<c:forEach items="${userList}" var="users">
            <tr>
                <td>${users.gender}</td>
                <td>${users.fullName}</td>
                <td>${users.email}</td>
                <td>${users.userName}</td>
                <td>${users.address}</td>
                <td>	<form id="deleteForm-${users.userName}" method="post"
							action="<%=contextPath + Stringutils.SERVLET_URL_MODIFY_USER %>">
							<input type="hidden" name="<%=Stringutils.DELETE_ID %>" value="${users.userName}" />
							<img src="<%= contextPath%>/resources/images/Userinterface/edit.svg" 
							class="image-delete" alt="..." width= 20 height = 20 >
							<button type="button" 
								onclick="confirmDelete('${users.userName}')"><img src="<%= contextPath%>/resources/images/Userinterface/delete.png" 
							class="image-delete" alt="..." width= 20 height = 20 ></button>
						</form></td> 
						
                
            </tr>
        </c:forEach>
        </c:if>
    </table>
</body>
<script>
	function confirmDelete(userName) {
		if (confirm("Are you sure you want to delete this user: " + userName
				+ "?")) {
			document.getElementById("deleteForm-" + userName).submit();
		}
	}
</script>
</html>