<%@ page import="model.User,java.util.ArrayList,model.Category"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="style1.css" />
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
			<a href="#" title="Login"></a>Log out
		</div>
		<div align="right" id="session" class="menu"><%="Hello " + user.getFirstName() + " " + user.getLastName()%></div>
	</div>
	<%
		String title = request.getAttribute("title") == null ? "" : (String) request.getAttribute("title");
		String description = request.getAttribute("description") == null ? ""
				: (String) request.getAttribute("description");
		String price = request.getAttribute("price") == null ? "" : String.valueOf(request.getAttribute("price"));
		String quantity = request.getAttribute("quantity") == null ? ""
				: String.valueOf(request.getAttribute("quantity"));
	%>
	<div align="center">
		<h1>Add New Product</h1>
		<form method="post" action="AddProduct.do"
			enctype="multipart/form-data">
			<fieldset>
				<p>
					<input type="text" name="title" placeholder="Title"
						value="<%=title%>" />
				</p>
				<p>
					<textarea rows="5" cols="30" name="description"
						placeholder="Description"><%=description%></textarea>
				</p>
				<p>
					<input type="text" name="price" placeholder="Price"
						value="<%=price%>" />
				</p>
				<p>
					<input type="text" name="quantity" placeholder="Quantity"
						value="<%=quantity%>" />
				</p>
				<p>
					<%
						if (request.getAttribute("categories") != null) {
							ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
					%><select name="idCategory">
						<option hidden value="chooseCategory">Choose Category</option>
						<%
							for (int i = 0; i < categories.size(); i++) {
						%>
						<option value="<%=categories.get(i).getCategoryId()%>"><%=categories.get(i).getCategoryEnum()%>
						</option>
						<%
							}
						%>
					</select>
					<%
						}
					%>

				</p>
				<p>
					<html:errors property="notification" />
				</p>
				<p>
					<input type="file" name="file" size="50" />
				</p>
				<p>
					<input type="submit" name="sub" value="Add Product To My Store" />
				</p>
			</fieldset>
		</form>
		<p>
			<%
				if (request.getAttribute("error") != null) {
					out.println(request.getAttribute("error"));
				}
			%>
		</p>
	</div>
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