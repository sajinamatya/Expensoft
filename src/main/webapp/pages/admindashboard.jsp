<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        height: 70vh; 
    }

    .dashboard-item {
        flex: 1  1 calc(33.33% - 10px); 
        margin: 20px;
        background-color: #f0f0f0;
        border: 2px solid #ccc;
        border-radius: 40px;
        padding: 2px 20px 30px 30px;
        height: 20vh;
        box-sizing: border-box;
        background-color: #5474AF;
    }
    h3{color: black;
    font-family :monospace;
         font-weight : 800}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />
<div class="admin-dashboard">
    <div class="dashboard-item"><h3>Total Number of User : <%= request.getAttribute("TotalUser") %> </h3> </div>
    <div class="dashboard-item"> <h3>Total Number of expense entry : <%= request.getAttribute("totalexpenseentry") %>  </h3> </div>
    <div class="dashboard-item"><h3>Total Number of income entry : <%= request.getAttribute("totalincomeentry") %></h3></div>
    <div class="dashboard-item"><h3>User with highest overall expense  : <br> 
    
    <c:forEach var="entry" items="${highexpense}">
            Name: ${entry.key} &nbsp;Amount: ${entry.value}
        </c:forEach> </h3></div>
    <div class="dashboard-item"><h3>User with highest overall Income :<br><c:forEach var="entry" items="${highincome}">
            Name: ${entry.key} &nbsp;Amount: ${entry.value}
        </c:forEach>  </h3> </div>
    <div class="dashboard-item"><h3>User with lowest expense : Alex</h3></div>
    
</div>

</body>
</html>