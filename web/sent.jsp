<%-- 
    Document   : sent
    Created on : 12-Dec-2024, 10:46:25 pm
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
 String[] selectedLanes = request.getParameterValues("lane");
            if (selectedLanes != null) {
                for (String lane : selectedLanes) {
                    out.println("<p>" + lane + "</p>");
                }
            } else {
                out.println("<p>No lanes selected.</p>");
            }        %>
        <h1>Hello World!</h1>
    </body>
</html>
