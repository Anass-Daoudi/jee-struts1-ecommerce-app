<%@ page import="model.User,java.util.ArrayList,model.Product"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/xhr.js"></script>
<script src="js/remove.js"></script>
<link rel="stylesheet" type="text/css" href="style1.css" />
<title>My Store</title>
</head>
<body>



	<%
		User user = (User) session.getAttribute("user");
	%>
	<div id="menu">

		<div class="menu">
			<a href="#" title="Acceuil">E-commerce</a>
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
	<a href="Shop.do">Shop</a>

	<%
		ArrayList<Product> myProducts = ((User) session.getAttribute("user")).getMyProducts();
	%>
	<div align="center">
		<h1>My Store</h1>
		<table border="1" width="70%" cellspacing=0 " cellpadding="0">

			<%
				if (myProducts != null) {
					for (int i = 0; i < myProducts.size(); i++) {
			%><tr>
				<td height="70" width="30%" align="center"><img
					src='<%=myProducts.get(i).getImageURL()%>' width='200' /></td>
				<td height="70" width="70%" align="center"><%=myProducts.get(i)%></td>
				<td height="70" width="70%" align="center"><input type="button"
					value="Remove From My Store"
					onClick="remove(<%=myProducts.get(i).getIdProduct()%>)" /></td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<form method="post" action="InitAddProduct.do">
			<p>
				<input type="submit" value="Add Product" />
			</p>
		</form>
		<div align="center">
			<br />
			<div id="shop">
				<a href="Shop.do">Shop</a>
			</div>
		</div>
	</div>
</body>
</html>