<%--
  Created by IntelliJ IDEA.
  User: Ali Raid Tahir
  Date: 28-04-2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="User" action="FrontController" method="post">
    <input type="hidden" name="target" value="UpdateUser">
    Navn: <br>
    <input type="text" name="name" value="" required>
    email: <br>
    <input type="text" name="email" value="" required>
    TelefonNummer: <br>
    <input type="number" name="phoneNumber" value="" required>
    addresse: <br>
    <input type="text" name="address" value="" required>
    Adgangskode: <br>
    <input type="text" name="Password" value="" reqired>
    <br>
    <input type="submit" value="Opdater bruger">
    

</form>

</body>
</html>
