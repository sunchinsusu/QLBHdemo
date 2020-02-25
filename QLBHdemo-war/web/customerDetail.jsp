<%-- 
    Document   : customerDetail
    Created on : Feb 24, 2020, 9:59:56 AM
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
            <input type="submit" name="action" value="Logout"/>
        </form>
        <br/>
        <h3>Customer Detail</h3>
        <form action="./CustomerDetailController" method="post">
            <input type="hidden" name="id" value="${customer.id}"/>
            Name: <input type="text" name="name" value="${customer.name}"/>
            <br/><br/>
            <input type="submit" name="action" value="SaveChange"/>
            <input type="submit" name="action" value="Delete"/>
        </form>
    </body>
</html>
