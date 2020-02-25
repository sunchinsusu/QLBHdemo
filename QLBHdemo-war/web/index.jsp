<%-- 
    Document   : login
    Created on : Feb 23, 2020, 8:41:09 PM
    Author     : Custom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <br/><br/>
        <form method="post" action="./LoginController">
            Username: <input type="text" name="username"/>
            <br/><br/>
            Password: <input type="password" name="password"/>
            <br/><br/>
            <input type="submit" name="action" value="Submit"/>
        </form>
        <br/>
        <c:if test="${mes != null}">
            <h4>${mes}</h4>
        </c:if>
    </body>
</html>
