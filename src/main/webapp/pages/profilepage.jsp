<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%
String contextPath = request.getContextPath();
%>
<%
 String userSessionsname = (String) session.getAttribute(Stringutils.USERNAME);
 String userSessionemail = (String) session.getAttribute("email");
 String userSessionphone = (String) session.getAttribute("phone");
 String userSessionfullname = (String) session.getAttribute("fullname");
 String userSessiongender = (String) session.getAttribute("gender");
 String userSessionaddress = (String) session.getAttribute("address");
 String userSessionimage = (String) session.getAttribute("image");
 %>
<%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/Header.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheet/profile.css" />
</body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />

	<div class="profile-main">
	<img alt="" src="">
	<form action="<%= contextPath%>/profilebase" method="POST" enctype ="multipart/form-data" >
			
			<img src="<%= contextPath%>/resources/images/User/<%=userSessionimage %>" 
							class="image" alt="..." height = 200 width = 200><br>
	
			<label for="email">Email :</label><br>
			<input type="text" id="email" name ='email' value="<%=userSessionemail %>" ><br>
			
		<label for="phone">Phone Number :</label><br>
			<input type="text" id="phone" name ='phone' value="<%=userSessionphone%>"  ><br>
		<label for="fullname">Full Name :</label>	<br>
		<input type="text" id="fullname" name ='fullname' value="<%=userSessionfullname%>"  ><br>
		<label for="userName">User Name :</label>	<br>
 
			<input type="text" id="name" name = 'userName' value ="<%=userSessionsname %>" ><br>
			<label for="userName">Gender : <%=userSessiongender %> </label>	<br>
			<label for="address">Address:</label>	<br>
			<input type="text" id="address" name = 'address' value ="<%=userSessionaddress%>"><br>
			<label for="address">New password :</label>	<br>
			<input type="password" id="password" name = 'newpassword'  required><br>
			<input type="submit" name="" value="save changes">
	
	
	</form>
	</div>

</html>