<%@ page import="java.util.ArrayList,model.Product,model.User"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="style1.css" />
<script src="js/xhr.js"></script>
<script src="js/removeshopping.js"></script>
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
	<br />
	<br />
	<div align="right" id="shoppingCart"><%=session.getAttribute("shoppingCart") == null ? "Cart: 0 products"
					: "Cart: " + ((ArrayList<Product>) session.getAttribute("shoppingCart")).size() + " products"%></div>
	<div align="center">
		<%
			ArrayList<Product> shoppingCart = (ArrayList<Product>) session.getAttribute("shoppingCart");

			if (shoppingCart != null && shoppingCart.size() != 0) {
				out.println("<table border=\"1\" width=\"70%\" cellspacing=\"0\" cellpadding=\"0\">");

				for (int i = 0; i < shoppingCart.size(); i++) {
					out.println("<tr>");
					out.println("<td height=\"70\" width=\"30%\" align=\"center\"><img src='"
							+ shoppingCart.get(i).getImageURL() + "' width='200' /></td>");
					out.println("<td height=\"70\" width=\"70%\" align=\"center\">" + shoppingCart.get(i) + "</td>");
					out.println(
							"<td height=\"70\" width=\"70%\" align=\"center\"><input onClick=\"removeProductShoppingCart("
									+ shoppingCart.get(i).getIdProduct()
									+ ")\" type=\"button\" value=\"Remove From Shopping cart\" />" + "</td>");
					out.println("<tr>");

				}
				out.println("</table>");
			} else {
				out.println("<h3>Sorry, no product is in your Shopping Cart</h3>");
			}
		%>
	</div>
	<br />
	<div align="center">
		<form action="https://www.paypal.com/cgi-bin/webscr" method="post">

			<!-- Saved buttons use the "secure click" command -->
			<input type="hidden" name="cmd" value="_s-xclick">

			<!-- Saved buttons are identified by their button IDs -->
			<input type="hidden" name="hosted_button_id" value="221">

			<!-- Saved buttons display an appropriate button image. -->
			<input type="image" name="submit"
				src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
				alt="PayPal - The safer, easier way to pay online"> <img
				alt="" width="1" height="1"
				src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif">

		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<div id="store">
			<a href="MyStore.do">My Store</a>
		</div>
		<br />
		<div id="shop">
			<a href="Shop.do">Shop</a>
		</div>
	</div>
</body>
</html>