<%-- 
    Document   : home
    Created on : Feb 23, 2020, 8:55:19 PM
    Author     : Custom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br/>
        <form action="./HomeController" method="post">
            <input type="submit" name="action" value="Product Manager"/>
            <input type="submit" name="action" value="Bill Manager"/>
            <input type="submit" name="action" value="Customer Manager"/>
            <input type="submit" name="action" value="Report Manager"/>
            <input type="submit" name="action" value="Logout"/>
        </form>
        <br/>
        <h1>Home Page</h1>
    </body>
</html>
