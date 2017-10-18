<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Log In</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%
		String email = request.getAttribute("email") == null ? "" : (String) request.getAttribute("email");
		String password = request.getAttribute("password") == null ? "" : (String) request.getAttribute("password");
	%>

	<div align="center">
		<%
			/*Boolean notification = (Boolean) request.getAttribute("notification");
			
			if (notification != null) {
				out.println("<div id='notification'>" + "Email or Password are incorrect! " + "</div>");
			}*/
		%>
		<div>
			<form method="post" action="Login.do">
				<input class="inp" type="email" name="email" placeholder="Email"
					value="<%=email%>" /> <input class="inp" type="password"
					name="password" placeholder="Password" value="<%=password%>" />
				<%
					if ((Boolean) request.getAttribute("notification") != null) {
						out.println("<div id='notification'>");
				%>
				<html:errors property='notification' />
				<%
					out.println("</div>");
					}
				%>
				<input id="sub" class="inp" type="submit" value="Log In" />
			</form>
		</div>
	</div>
</body>
</html>