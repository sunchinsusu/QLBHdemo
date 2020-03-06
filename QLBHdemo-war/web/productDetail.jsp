<%-- 
    Document   : productDetail
    Created on : Feb 24, 2020, 9:30:12 AM
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
        <h3>Product Detail</h3>
        <form action="./ProductDetailController" method="post">
            <input type="hidden" name="id" value="${product.id}"/>
            Name: <input type="text" name="name" value="${product.name}"/>
            <br/><br/>
            Price: <input type="number" name="price" value="${product.price}"/>
            <br/><br/>
            <input type="submit" name="action" value="SaveChange"/>
            <input type="submit" name="action" value="Delete"/>
        </form>
    </body>
</html>
