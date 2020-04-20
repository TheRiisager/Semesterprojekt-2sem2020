<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <table style="width: 75%;">
            <tr style="font-weight: bold;">
                <td>ID</td>
                <td>Dimensioner</td>
            </tr>
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td>${order.getOrderID()}</td>
                    <td>${order.getCarportLength()}x${order.getCarportWidth()}x${order.getCarportHeight()}</td>
                </tr>
            </c:forEach>
        </table>


        <h1>Hello ${sessionScope.email} </h1>



        You are now logged in as a EMPLOYEE of our wonderful site.
    </body>
</html>
