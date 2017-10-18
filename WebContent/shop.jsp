<%@ page
	import="java.util.ArrayList,model.User,model.Product,model.Category"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<script src="js/xhr.js"></script>
<script src="js/categories.js"></script>
<script src="js/products.js"></script>
<script src="js/shopping.js"></script>
<link rel="stylesheet" type="text/css" href="style1.css" />
<title>Shop</title>
</head>
<body>
<body onLoad="categories()">
	<%
		User user = (User) session.getAttribute("user");
	%>
	<div id="menu">

		<div class="menu">
			<a href="homee.jsp" title="Acceuil">E-commerce</a>
		</div>
		<div class="menu">
			<a href="#" title="contact us">Contact us</a>

		</div>
		<div class="menu">
			<form action="Disconnect.do" method="post">
				<input id="disconnect" type="submit" value="Disconnect" />
			</form>
		</div>
		<div align="right" id="session" class="menu"><%="Hello " + user.getFirstName() + " " + user.getLastName()%></div>
	</div>
	<br />
	<div align="right" id="shoppingCart"><%=session.getAttribute("shoppingCart") == null ? "Cart: 0 products"
					: "Cart: " + ((ArrayList<Product>) session.getAttribute("shoppingCart")).size() + " products"%></div>
	<a href="MyStore.do">My Store</a>
	<div align="center">
		<h1>Shop</h1>
		<div id="store">
			<a href="MyStore.do">My Store</a>
		</div>
		<br />
		<div id="categories"></div>
		<br />
		<div id="products"></div>
		<br />

		<div id="displayShoppingCart">
			<form method="POST" action="DisplayShoppingCartAction.do">
				<input type="submit" value="Display Shopping Cart" />
			</form>
		</div>

	</div>
</body>
</body>
</html>