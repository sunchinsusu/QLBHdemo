<%-- 
    Document   : billDetail
    Created on : Feb 24, 2020, 6:59:03 PM
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
        <br/>
        <h3>Bill Detail</h3>
        <br/>
        Name: ${bill.getIdCustomer().getName()}
        <br/>
        Date: ${bill.date}
        <br/><br/>
        <table>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="billDetail" items="${billDetails}">
                <tr>
                    <td>${billDetail.getIdProduct().getName()}</td>
                    <td>${billDetail.getIdProduct().getPrice()}</td>
                    <td>${billDetail.quantity}</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td>Total:</td>
                <td>${total}</td>
            </tr>        
        </table>
        <form action="./BillDetailController" method="post">
            <input type="hidden" name="id" value="${bill.id}"/>        
            <input type="submit" name="action" value="Delete"/>
        </form>
    </body>
</html>
