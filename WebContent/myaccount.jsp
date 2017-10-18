<%@ page import="java.util.ArrayList,model.User,model.Product"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Account</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
	%>

	<div align="right"><%="Hello " + user.getFirstName() + " " + user.getLastName()%></div>
	<div align="right" id="shoppingCart"><%=session.getAttribute("shoppingCart") == null ? "Cart: 0 products"
					: "Cart: " + ((ArrayList<Product>) session.getAttribute("shoppingCart")).size() + " products"%></div>
	<br />
	<div align="right">
		<%@ include file="disconnect.jsp"%>
	</div>
	<a href="MyStore.do">My Store</a>
	<a href="Shop.do">Shop</a>
</body>
</html>