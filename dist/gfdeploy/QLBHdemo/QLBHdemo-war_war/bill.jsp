<%-- 
    Document   : bill
    Created on : Feb 24, 2020, 8:49:50 AM
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
        <form action="./BillController" method="post">
            Customer: 
            <select name="idCustomer" >
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </select>
            <br/><br/>
            <input type="submit" name="action" value="New bill"/>
        </form>
        <br/><br/><br/>
        <table>
            <tr>
                <th>Id</th>
                <th>Date</th>
                <th>Customer</th>
                <th>Status</th>
                <th></th>
            </tr>
            <c:forEach var="bill" items="${bills}">
                <form action="./BillController" method="post">
                    <input type="hidden" name="id" value="${bill.id}"/>
                    <tr>
                        <td>${bill.id}</td>
                        <td>${bill.date}</td>
                        <td>${bill.getIdCustomer().getName()}</td>
                        <td>${bill.getStatus()}</td>
                        <td><input type="submit" name="action" value="View Detail"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>    
    </body>
</html>
