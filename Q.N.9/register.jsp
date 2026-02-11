<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
    // Visitor Counter using Application Scope
    Integer visitCount = (Integer)application.getAttribute("visitCount");

    if(visitCount == null){
        visitCount = 1;
    } else {
        visitCount = visitCount + 1;
    }

    application.setAttribute("visitCount", visitCount);

    // Get logged in user from session
    String username = (String)session.getAttribute("username");
%>

<html>
<head>
    <title>Registration Page</title>
</head>
<body>

<h2>Registration Form</h2>

<!-- Display Visitor Count -->
<p><b>Total Visitors:</b> <%= visitCount %></p>

<!-- Display Logged In User -->
<%
    if(username != null){
%>
        <p style="color:green;">Welcome, <b><%= username %></b></p>
        <a href="logout.jsp">Logout</a><br><br>
<%
    }
%>

<form action="process.jsp" method="post">
    Name: <input type="text" name="name" required /><br><br>
    Email: <input type="email" name="email" required /><br><br>
    Password: <input type="password" name="password" required /><br><br>
    <input type="submit" value="Register" />
</form>

</body>
</html>
