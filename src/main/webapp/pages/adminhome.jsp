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
            <th>Full Name </th>
            <th>Gender </th>
            <th>Email</th>
            <th>User name </th>
            <th>Date Of birth</th>
            <th>PhoneNumber </th>
            <th>Address </th>
            <th> Action </th>
        </tr>
        <c:if test="${not empty userList}">
	<c:forEach items="${userList}" var="users">
            <tr>
                <td>${users.fullName}</td>
                <td>${users.gender}</td>
                <td>${users.email}</td>
                <td>${users.userName}</td>
                <td>${users.dateOfBirth}</td>
                 <td>${users.phoneNumber}</td>
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
    <div class = "addUser">
    <form action="<%=contextPath + Stringutils.SERVLET_URL_ADMIN_ADD%>" method="post" enctype ="multipart/form-data" >
			<div class="row">
				<div class="col">
					<label for="fullName">Full Name :</label> <input type="text"
						id="fullName" name="fullName" required>
				</div>
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
						
				</div>
				<div class="col">
					<label for="username">Username:</label> <input type="text"
						id="username" name="userName" required>
				</div>
			</div>
			<div class="row">
				
				<div class="col">
					<label for="dateOfbirth">Date of Birth:</label> <input type="date"
						id="dateOfBirth" name="dateOfBirth" required>
				</div>
				<div class="col">
					<label for="gender">Gender:</label> <select id="gender"
						name="gender" required>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="col">
					<label for="phoneNumber">Phone Number:</label> <input type="tel"
						id="phoneNumber" name="phoneNumber" required>
				</div>

			</div>
			<div class="row">
				
			</div>
			<div class="row">
				<div class="col">
					<label for="address">Address</label> <input type="text"
						id="address" name="address" required>
				</div>
				<div class="col">
					<label for="securityQn"> Favorite item?  </label> <input type="text"
						id="securityQn" name="securityQn" required>
				</div>
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
			</div>
			<div class="row">
			
				</div>
				<div class ="row"> 
				<div class = 'col'> 
				<label for = "image"> Profile picture </label> <input type ="file" id ="image" name ="image">
 				</div>
				<div class = 'col'><input type="submit" name="" value="Sign up"> </div>
				</div>
				
			</form>
			<%
		String errMsg = (String) request.getAttribute(Stringutils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(Stringutils.MESSAGE_SUCCESS);

		if (errMsg != null) {
			// print
		%>
		<h2 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h2>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h2 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h2>
		<%
		}
		%>
			
    
    
    </div>
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