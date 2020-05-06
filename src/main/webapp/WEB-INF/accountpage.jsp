<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 23-04-2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<form name="UserInfo" action="FrontController" method="POST">
    <p>Navn: ${sessionScope.name}</p>
    <p>Adresse: ${sessionScope.address}</p>
    <p>Telefon: ${sessionScope.phonenumber}</p>
    <input type="hidden" name="target" value="updateuser">
    <input type="submit" value="Updater info">
</form>
<c:forEach var="order" items="${sessionScope.orderslist}">
    <tr>
        <td>${order.getOrderID()}</td>
        <td>B:${order.getCarportWidth()} L:${order.getCarportLength()}</td>
        <td>${order.getStatus()}</td>
    </tr>
    <br>
</c:forEach>

<jsp:include page="footer.jsp"/>
