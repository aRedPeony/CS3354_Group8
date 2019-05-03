<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brief_history_comments</title>
<link rel="stylesheet" type="text/css" href="main_style.css">

</head>
<body>
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
	<div style="text-align:right"><a id=logout href="logout.jsp">logout</a></div>
	<h1 class="heading">Comments:</h1>
	<div class=main>
	
	<br><br><form name="seeComments" action="commentsO" method="post">
	<input type="submit" name="submit" value="See Comments on Brief History">
	<div class=link><a href=readComents.html>Comments</a></div>
	</form>
	
	<br>
	${cMessage}<br>
	
	<form name="comment" action="commentsI" method="post" onsubmit="return commentValidate()" >
	
	Comment:<input type="text" name="comment" id="comment"><br><br>
	
	<input type="submit" name="submit" value="Comment on Brief History">
	
	</form>
	</div>
</body>
</html>