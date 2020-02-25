<%-- 
    Document   : customer
    Created on : Feb 24, 2020, 8:49:40 AM
    Author     : Custom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <form action="./CustomerController" method="post">
            Name: <input type="text" name="name"/>
            <br/><br/>
            <input type="submit" name="action" value="Add"/>
        </form>
        <br/><br/><br/>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th></th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <form action="./CustomerController" method="post">
                    <input type="hidden" name="id" value="${customer.id}"/>
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td><input type="submit" name="action" value="View Detail"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>    
    </body>
</html>
