<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Sign Up</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%
		String firstName = request.getAttribute("firstName") == null ? ""
				: (String) request.getAttribute("firstName");
		String lastName = request.getAttribute("lastName") == null ? "" : (String) request.getAttribute("lastName");
		String email = request.getAttribute("email") == null ? "" : (String) request.getAttribute("email");
		String password = request.getAttribute("password") == null ? "" : (String) request.getAttribute("password");
		String passwordConfirmation = request.getAttribute("passwordConfirmation") == null ? ""
				: (String) request.getAttribute("passwordConfirmation");
		String civility = request.getAttribute("civility") == null ? "" : (String) request.getAttribute("civility");
		String male = "", female = "";

		if (civility.equals("Male")) {
			male = "checked";
		} else if (civility.equals("Female")) {
			female = "checked";
		}
	%>

	<div align="center">
		<%
			/*String notification = (String) request.getAttribute("notification");
			
			if (notification != null && !notification.isEmpty()) {
				out.println("<div id='notification'>" + notification + "</div>");
			}*/
		%>
		<div>
			<form method="post" action="SignUp.do">
				<input class="inp" type="text" name="firstName"
					placeholder="First Name" autofocus value="<%=firstName%>" /> <input
					class="inp" type="text" name="lastName" placeholder="Last Name"
					value="<%=lastName%>" /> <input class="inp" type="email"
					name="email" placeholder="Email" value="<%=email%>" /> <input
					class="inp" type="password" name="password" placeholder="Password"
					value="<%=password%>" /> <input class="inp" type="password"
					name="passwordConfirmation" placeholder="Password Confirmation"
					value="<%=passwordConfirmation%>" />
				<div>
					Male.<input type="radio" name="civility" <%=male%> value="Male" />&nbsp;&nbsp;&nbsp;&nbsp;
					Female.<input type="radio" name="civility" <%=female%>
						value="Female" />&nbsp;&nbsp;&nbsp;&nbsp;
				</div>

				<%
					if ((Boolean) request.getAttribute("notification") != null) {
						out.println("<div id='notification'>");
				%>
				<html:errors property='notification' />
				<%
					out.println("</div>");
					}
				%>
				<input id="sub" class="inp" type="submit" value="Create An Account" />
			</form>
		</div>
	</div>
</body>
</html>