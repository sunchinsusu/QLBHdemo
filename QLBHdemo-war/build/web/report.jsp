<%-- 
    Document   : report
    Created on : Mar 6, 2020, 8:46:56 AM
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
        <form action = "./ReportController" method="post">
            Type: 
            <select name="typeReport" >
                <option value="Payment">Payment Report</option>
            </select>
            <br/><br/>
            StartDate: <input type="date" name="startDate"/>
            <br/><br/>
            EndDate: <input type="date" name="endDate"/>
            <br/><br/><br/>
            <input type="submit" name="action" value="ViewReport"/>
        </form>
    </body>
</html>
