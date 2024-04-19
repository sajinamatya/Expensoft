<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String contextPath = request.getContextPath();%>
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
		<form action="" method="post">
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
						id="username" name="username" required>
				</div>
				<div class="col">
					<label for="dateofbirth">Date of Birth:</label> <input type="date"
						id="dateofbirth" name="dateofbirth" required>
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
					<label for="Address">Address</label> <input type="text"
						id="Address" name="Address" required>
				</div>
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
				</div>
				<div class="col">
				</div>
			</div>
			<input type="submit" name="" value="Sign up"> <h2><a href ="<%=contextPath%>/pages/login.jsp">login</a></h2>
		</form>
		
	</div>
	<div class='signup-right'></div>
</div>
</body>
</html>