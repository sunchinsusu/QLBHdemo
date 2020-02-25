<%-- 
    Document   : cart
    Created on : Feb 24, 2020, 10:26:28 AM
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
        <h4>${customer.name}</h4>  
        <br/>
        <h2>Your Cart</h2>
        <br/>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            <c:forEach var="billDetail" items="${cart}">
                <form action="./CartController" method="post">
                    <input type="hidden" name="idProduct" value="${billDetail.getIdProduct().getId()}"/>
                    <tr>
                        <td>${billDetail.getIdProduct().getName()}</td>
                        <td>${billDetail.getIdProduct().getPrice()}</td>
                        <td>${billDetail.quantity}</td>
                        <td><input type="submit" name="action" value="Remove"/></td>
                    </tr>
                </form>
            </c:forEach>
            <tr>
                <td></td>
                <td>Total: </td>
                <td>${total}</td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>
                    <form action="./CartController" method="post">
                        <input type="hidden" name="idCustomer" value="${customer.id}"/>
                        <input type="submit" name="action" value="Create Bill"/>
                    </form>
                </td>
            </tr>
        </table>
        <br/><br/>
        <h3>List Product</h3>
        <br/>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${products}">
                <form action="./CartController" method="post">
                    <input type="hidden" name="idProduct" value="${product.id}"/>
                    <tr>
                        <td>${product.getName()}</td>
                        <td>${product.getPrice()}</td>
                        <td><input type="number" name="quantity" required/></td>
                        <td><input type="submit" name="action" value="Add to Cart"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
