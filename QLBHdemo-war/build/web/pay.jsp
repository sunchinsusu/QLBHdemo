<%-- 
    Document   : pay
    Created on : Mar 5, 2020, 8:45:30 AM
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
            <c:forEach var="billDetail" items="${billItems}">
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
            <input type="submit" name="action" value="PrintReport"/>
        </form>    
        <br/>
        <h4>Payment history</h4>
        <table>
            <tr>
                <th>Date</th>
                <th>Amount</th>
                <th>Payment method</th>
                <th>Note</th>
            </tr>
            <c:forEach var="payDetail" items="${payDetails}">
                <tr>
                    <td>${payDetail.date}</td>
                    <td>${payDetail.amount}</td>
                    <td>${payDetail.paymentMethod}</td>
                    <td>${payDetail.note}</td>
                </tr>
            </c:forEach>       
        </table>    
        <br/>
        <form action="./PaymentController" method="post">
            Amount: <input type="number" name="amount"/>
            Payment method: 
            <select name="paymentMethod" >
                <c:forEach var="method" items="${methods}">
                    <option value="${method}">${method}</option>
                </c:forEach>
            </select>
            Note: <input type="text" name="note"/>
            <input type="hidden" name="id" value="${bill.id}"/>
            <input type="submit" name="action" value="Pay"/>
        </form>
        <c:if test="${mes!=null}">
            ${mes}
        </c:if>    
    </body>
</html>
