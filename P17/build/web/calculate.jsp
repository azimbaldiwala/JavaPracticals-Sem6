<%-- 
    Document   : calculate
    Created on : Feb 23, 2022, 9:15:13 AM
    Author     : Azim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Grade</title>
    </head>
    <body>
        <%
        
            int cmt = Integer.parseInt(request.getParameter("cmt"));
            int dwd = Integer.parseInt(request.getParameter("dwd"));
            int java = Integer.parseInt(request.getParameter("java"));
            int cns = Integer.parseInt(request.getParameter("cns"));
            
            double grade  = (cmt + dwd + java + cns) / 4;
            out.println("<h1>You have Scored: </h1>");
            if(grade >= 80){
                out.println("<h1>A</h1>");
            }else if(grade >= 60){
                out.println("<h1>B</h1>");
            }else if(grade >= 50){
                out.println("<h1>C</h1>");
            }else if(grade >= 40){
                out.println("<h1>D</h1>");
            }else if(grade < 40){
                out.println("<h1>F</h1>");
            }
            
            
        %>
    </body>
</html>
