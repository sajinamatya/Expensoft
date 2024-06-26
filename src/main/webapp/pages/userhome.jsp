<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String contextPath = request.getContextPath();
%>
<%
		String userSessions = (String) session.getAttribute(Stringutils.USERNAME);
		
		
	%>
<%@page import="utils.Stringutils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/Header.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/userhome.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheet/footer.css" />
<body>
<jsp:include page="<%=Stringutils.PAGE_URL_HEADER%>" />
<h1 style='Text-align:center;'>Hey <%=userSessions %>. Let's track your expense and income</h1>
<div class="main">
<div class="expense">
<form action="<%= contextPath%>/expense" method="post" onsubmit="alert('Expense added')">
<h1>Expense</h1>
<label for = "expenseAmount"> Expense Amount </label> <br>
<input type="text" id="expenseAmount" name="expenseAmount" required><br>
<label for = "expenseCategory"> Expense Category </label> <br>
<select id="expenseCategory"	name="expenseCategory" required>
						<option value="Housing">Housing</option>
						<option value="Utilities">Utilities</option>
						<option value="Transportation">Transportation</option>
						<option value="Food">Food</option>
						<option value="Entertainment">Entertainment</option>
						<option value="Healthcare">Health care</option>
						<option value="other">Other</option>
					</select><br>
<label for = "expenseDate"> Expense Date</label><br>
<input type="date"id="expenseDate" name="expenseDate" required>
<label for="subject">Expense Description</label><br>
    <textarea id="subject" name="expenseDesc" placeholder="Expense" required></textarea>
    <input type="submit" name="addExpense" value="Add Expense">
    </form>
</div>

<div class= "income">
<form action="<%=contextPath%>/income" method="post" onsubmit="alert('Income added')">
<h1> Income</h1>
<label for = "incomeAmount"> Income Amount </label> <br>
<input type="text" id="incomeAmount" name="incomeAmount" required><br>
<label for = "incomeCategory"> Income Category </label> <br>
<select id="incomeCategory"	name="incomeCategory" required>
						<option value="Salary">Salary</option>
						<option value="Rental Income">Rental Income</option>
						<option value="Investment">Investment</option>
						<option value="Freelance Earning">Freelance Earning</option>
						<option value="Bank Interest Income">Bank Interest Income </option>
						<option value="Other">Other</option>
					</select><br>
					<label for = "incomeDate"> Income Date</label> <br>
<input type="date"id="incomeDate" name="incomeDate" required>
<label for="subject">Income Description</label><br>
    <textarea id="subject" name="incomeDesc" placeholder="Income" required></textarea>
    <input type="submit" name="addIncome" value="Add Income" >
    </form>
</div>

</div>


<script>
	
	
</script>
<jsp:include page="<%=Stringutils.PAGE_URL_FOOTER%>" />
</body>
</html>