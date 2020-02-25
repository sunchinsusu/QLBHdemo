<%-- 
    Document   : product
    Created on : Feb 23, 2020, 9:35:34 PM
    Author     : Custom
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <br/><br/>
        <form action="./ProductController" method="post">
            Name: <input type="text" name="name"/>
            <br/><br/>
            Price: <input type="number" name="price"/>
            <br/><br/>
            <input type="submit" name="action" value="Add"/>
        </form>
        <br/><br/><br/>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${products}">
                <form action="./ProductController" method="post">
                    <input type="hidden" name="id" value="${product.id}"/>
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td><input type="submit" name="action" value="View Detail"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>    
    </body>
</html>
