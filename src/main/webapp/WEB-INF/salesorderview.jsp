<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 21-04-2020
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p style="color: #cc1346">${statuserror}</p>
    <p>
       ID: ${sessionScope.oid}
    </p>

    <form>
        <input type="hidden" name="target" value="UpdateOrder">
        <p>Lændge:</p>
        <input type="text" name="length" value="${sessionScope.length}">
        <br>
        <p>Bredde:</p>
        <input type="text" name="width" value="${sessionScope.width}">
        <br>
        <input type="number" name="status" value="${sessionScope.status}">
        <input type="submit" value="Opdater værdier">
    </form>

    ${sessionScope.svg}

    <table class="table table-hover" style="width: 75%;">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Dimensioner</th>
            <th>Antal</th>
            <th>Pris (i alt)</th>
        </tr>
        </thead>


    <c:forEach var="entry" items="${sessionScope.componentList}">
        <tr>
            <td>${entry.getKey().getMaterialID()}</td>
            <td>${entry.getKey().getName()}</td>
            <td>H:${entry.getKey().getHeight()} B:${entry.getKey().getWidth()} L:${entry.getKey().getLength()}</td>
            <td>${entry.getValue()}</td>
            <td>${entry.getKey().getPrice() * entry.getValue()}kr.</td>
        </tr>
    </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td style="font-weight: bold">Total: ${sessionScope.totalPrice}kr.</td>
        </tr>
    </table>

</body>
</html>
