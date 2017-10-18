<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Home</title>
</head>
<body>
	<!-- 	<%@ include file="header.jsp"%>-->
	<div id="logo" align="center">
		<h1>Online Store</h1>
	</div>
	<div id="container" align="center">
		<form class="signupin" method="post" action="signup.jsp">
			<input class="signupin" type="submit" value="Sign Up" />
		</form>
		<form class="signupin" method="post" action="login.jsp">
			<input class="signupin" type="submit" value="Log In" />
		</form>
	</div>
</body>
</html>