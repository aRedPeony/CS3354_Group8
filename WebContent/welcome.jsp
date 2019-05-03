<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="main_style.css">

</head>
<body>
	<div style="text-align:right"><a id=logout href="logout.jsp">logout</a></div>
	
	<h1 class="heading">History of Anime</h1>
	
	<div class=main>
		<h2 class=link> ${message}!</h2>

		<div class=link><a href=Brief_history.jsp>A Brief History of Anime</a></div>
	</div>

</body>
</html>