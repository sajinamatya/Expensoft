<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.Stringutils"%>
<%@page import="model.ExpenseModel"%>
    <%
String contextPath = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Header.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/footer.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/userdashboard.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />

<div class="user-dashboard">
    <div class="user-item"><h3>Total Income : <%= request.getAttribute("totalincome") %> </h3> </div>
    <div class="user-item"> <h3>Total Expense : <%= request.getAttribute("totalexpense") %></h3> </div>
    <div class="user-item"><h3>Category most expense :</h3> <c:forEach var="entry" items="${expenseCategory}">
            <h3>${entry.key}: ${entry.value}</h3>
        </c:forEach></div>
    <div class="user-item"><h3>Category with most income : </h3> <c:forEach var="entry" items="${incomeCategory}">
            <h3>${entry.key}: ${entry.value}</h3>
        </c:forEach></div>
    
</div>
<h1>Expense Detail</h1>
<c:if test="${empty expenseList}">
				<p>No expense detail   found.</p>
</c:if>
    <table>
        <tr>
            <th>Expense Date</th>
            <th>Expense category </th>
            <th>Expense Amount</th>
            <th>Expense Description </th>
            
        </tr>
        <c:if test="${not empty expenseList}">
	<c:forEach items="${expenseList}" var="expense">
            <tr>
                <td>${expense.expense_date}</td>
                <td>${expense.expense_category}</td>
                <td>${expense.expense_amount}</td>
                <td>${expense.expense_description}</td>		
                
            </tr>
        </c:forEach>
        </c:if>
    </table>
    
    <h1>Income Detail</h1>
<c:if test="${empty incomeList}">
				<p>No income detail   found.</p>
</c:if>
    <table>
        <tr>
            <th>income Date</th>
            <th>income category </th>
            <th>income Amount</th>
            <th>income Description </th>
            
        </tr>
        <c:if test="${not empty incomeList}">
	<c:forEach items="${incomeList}" var="income">
            <tr>
                <td>${income.income_date}</td>
                <td>${income.income_category}</td>
                <td>${income.income_amount}</td>
                <td>${income.income_description}</td>		
                
            </tr>
        </c:forEach>
        </c:if>
    </table>
 <jsp:include page="<%=Stringutils.PAGE_URL_FOOTER%>" />
</body>
</html>