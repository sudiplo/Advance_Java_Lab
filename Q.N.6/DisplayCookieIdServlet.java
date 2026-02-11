import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayCookieIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession s = req.getSession();

        out.println("<h2>Session & Cookie Information</h2>");
        out.println("<b>Session ID:</b> " + s.getId() + "<br>");
        out.println("<b>Is new session?</b> " + s.isNew() + "<br>");
        out.println("<b>Created at:</b> " + new java.util.Date(s.getCreationTime()) + "<br>");
        out.println("<b>Last accessed:</b> " + new java.util.Date(s.getLastAccessedTime()) + "<br>");

        out.println("<h3>Cookies:</h3>");
        Cookie[] c = req.getCookies();
        if (c != null)
            for (Cookie ck : c)
                out.println(ck.getName() + " : " + ck.getValue() + "<br>");

        out.println("<br><a href='displaycookie'>Refresh</a>");
    }
}
