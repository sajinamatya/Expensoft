<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 
<%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
    <%
String contextPath = request.getContextPath();
%>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Header.css" />
<style>
body{
background-color:#98a2a5;
	font-family: monospace;
}
.admin-dashboard {
        display: flex;
        flex-wrap: wrap;
        margin-left:200px;
        margin-top : 60px;
        width: 70%;
        height: 100vh; /* Adjust the height as needed */
    }

    .dashboard-item {
        flex: 1  1 calc(33.33% - 10px); /* Adjust the width and margins as needed */
        margin: 10px;
        background-color: #f0f0f0;
        border: 2px solid #ccc;
        border-radius: 40px;
        padding: 20px;
        height: 20vh;
        box-sizing: border-box;
    }
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />
<div class="admin-dashboard">
    <div class="dashboard-item"><h3>Total Number of User : <%= request.getAttribute("TotalUser") %> </h3> </div>
    <div class="dashboard-item"> <h3>Total Number of expense entry :  </h3> </div>
    <div class="dashboard-item"><h2>Category with most income :Business Income</h2></div>
    <div class="dashboard-item"><h2>User with highest expense amount : Ram </h2></div>
    <div class="dashboard-item"><h2>User with highest income amount : Harry</h2> </div>
    <div class="dashboard-item"><h2>User with lowest expense : Alex</h2></div>
    
</div>

</body>
</html>