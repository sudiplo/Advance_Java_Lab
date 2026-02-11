<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // Store username in session
    session.setAttribute("username", name);
%>

<html>
<head>
    <title>Registration Success</title>
</head>
<body>

<h2>Registration Successful!</h2>

<p>Welcome, <b><%= name %></b></p>
<p>Email: <%= email %></p>

<a href="register.jsp">Go Back</a>

</body>
</html>
