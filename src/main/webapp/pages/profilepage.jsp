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

 String errMsg = (String) request.getAttribute(Stringutils.MESSAGE_ERROR);
 String successMsg = (String) request.getAttribute(Stringutils.MESSAGE_SUCCESS);
 String successParam = request.getParameter(Stringutils.SUCCESS);

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
	<form action="<%=contextPath%>/profile" method="POST"  >
			
			<img src="<%= contextPath%>/resources/images/User/<%=userSessionimage %>" 
							class="image" alt="..." height = 200 width = 200><br>
	
			<label for="email">Email </label><br>
			<input type="text" id="email" name ='email' value="<%=userSessionemail %>" ><br>
			
		<label for="phone">Phone Number </label><br>
			<input type="text" id="phone" name ='phoneNumber' value="<%=userSessionphone%>"  ><br>
		<label for="fullname">Full Name </label>	<br>
		<input type="text" id="fullName" name ="fullName" value="<%=userSessionfullname%>"  ><br>
		<label for="userName">User Name </label>	<br>
 
			<input type="text" id="name" name = 'userName' value ="<%=userSessionsname %>" ><br>
			<label for="userName">Gender  <%=userSessiongender %> </label>	<br>
			
			<label for="address">Address</label>	<br>
			<input type="text" id="address" name = 'address' value ="<%=userSessionaddress%>"><br>
			
			<input type="submit" name="save" value="save changes"><br>
			<%
		if (errMsg != null) {
			// print
		%>
		<h3 class="error">
			<%
			out.println(errMsg);
			%>
		</h3>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h3 class="success">
			<%
			out.println(successMsg);
			%>
		</h3>
		<%
		}
		%>
	
	</form>
	<form action="<%=contextPath%>/profile" method="POST"  >
	<h1 style="margin-left:70px;"> Change your Password</h1>
	<label for="address"> old password </label>	<br>
			<input type="password" id="password" name = 'password'  ><br>
	
	 <label for="address">New password </label>	<br>
			<input type="password" id="password" name = 'newpassword'  ><br>
			
			<input type="submit" name="updatepassword" value="update Password">
			</form>
		
	<h1 style="margin-left:70px;"> Delete your account</h1>
	
	
		<input type="submit" name="updatepassword" value="Delete Account " style= "background-color:red;">
	</div>

</html>