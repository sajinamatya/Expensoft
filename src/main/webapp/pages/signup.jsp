<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String contextPath = request.getContextPath();%>
    <%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up </title>
</head>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/signup.css" />
<body>
<div class="signup-form">
<div class = 'signup-left'> 
		<h1>Signup</h1>
		<h2> Track your expense and income</h2>
		<form action="<%=contextPath%>/signup" method="post">
			<div class="row">
				<div class="col">
					<label for="fullName">Full Name :</label> <input type="text"
						id="fullName" name="fullName" required>
				</div>
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> <input type="text"
						id="username" name="userName" required>
				</div>
				<div class="col">
					<label for="dateOfbirth">Date of Birth:</label> <input type="date"
						id="dateOfBirth" name="dateOfBirth" required>
				</div>

			</div>
			<div class="row">
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
				<div class="col">
					<label for="address">Address</label> <input type="text"
						id="address" name="address" required>
				</div>
				<div class="col">
					<label for="securityQn"> Favorite item?  </label> <input type="text"
						id="securityQn" name="securityQn" required>
				</div>
			</div>
			<div class="row">
			<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="col">
					<label for="Retype Password"> Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
				</div>
				
			</div>
			<input type="submit" name="" value="Sign up"> 
			<h2>Already have an account?<a href ="<%=contextPath%>/pages/login.jsp" style="text-decoration:None"> login</a></h2>
		</form>
<%
		String errMsg = (String) request.getAttribute(Stringutils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(Stringutils.MESSAGE_SUCCESS);

		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h4 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h4>
		<%
		}
		%>
		
		
	</div>
	<div class='signup-right'></div>
</div>
</body>
</html>