<%@ page import="java.util.*,javax.servlet.http.*" %>

<h2>Session & Cookie Information</h2>

<b>Session ID:</b> <%= session.getId() %><br>
<b>Is new session?</b> <%= session.isNew() %><br>
<b>Created at:</b> <%= new Date(session.getCreationTime()) %><br>
<b>Last accessed:</b> <%= new Date(session.getLastAccessedTime()) %><br>

<h3>Cookies:</h3>
<%
Cookie[] c = request.getCookies();
if (c != null)
    for (Cookie ck : c)
        out.println(ck.getName() + " : " + ck.getValue() + "<br>");
%>

<br><a href="display-cookie-id.jsp">Refresh</a>
