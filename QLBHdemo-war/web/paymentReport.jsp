<%-- 
    Document   : paymentReport
    Created on : Mar 6, 2020, 8:58:14 AM
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
            <input type="submit" name="action" value="Report Manager"/>
            <input type="submit" name="action" value="Logout"/>
        </form>
        <br/><br/>
        <h3>PaymentReport</h3>
        Form: ${startDate}
        To: ${endDate}
        <br/><br/>
        <table>
            <tr>
                <th>Date</th>
                <th>Amount</th>
                <th>Payment Method</th>
                <th>Note</th>
            </tr>
            <c:forEach var="paymentDetail" items="${payDetails}">
                <tr>
                    <td>${paymentDetail.date}</td>
                    <td>${paymentDetail.amount}</td>
                    <td>${paymentDetail.paymentMethod}</td>
                    <td>${paymentDetail.note}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
