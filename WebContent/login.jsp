<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="main_style.css">

</head>
<body>
	<h1 class=heading><%out.print("Hello!"); %></h1>
	<div class=main>
	<%= new java.util.Date() %>
	
	
	<%! int number1, number2; %>
	
	<%
		DbManager db = new DbManager();
		Connection conn = (Connection) db.getConnection();
		if(conn == null)
			out.print("failed");
		else
			out.print("succeeded");
	
	%>
	<br/>
	
	<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	
	<br>
	${message}<br>
	${successMessage}<br>
	
	Username: <input type="text" name="username" id="username"><br>
	Password: <input type="password" name="password" id="password"><br>
	<input type="submit" name="submit" value="login"><br>
	<a href="register.jsp">registration</a>
	</div>
	</form>
</body>
</html>