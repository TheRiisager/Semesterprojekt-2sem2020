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
        <p>Højde:</p>
        <input type="text" name="height" value="${sessionScope.height}">
        <br>
        <input type="submit" value="Opdater værdier">
    </form>
</body>
</html>
