<%--
  Created by IntelliJ IDEA.
  Author: Christoffer
  Date: 21-04-2020
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
</head>
<body>
<h1>Login/registrer</h1>


<table>
    <tr><td>Login</td>
        <br>
        <td>
            <br>
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="target" value="login">
                Email:<br>
                <input type="text" name="email" value="robin@somewhere.com" required>
                <br>
                Adgangskode:<br>
                <input type="password" name="password" value="batman" required>
                <br>
                <input type="submit" value="Log ind">
            </form>
        </td>
        <br>
        <td>Or Register</td>
        <br>
        <td>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="target" value="register">
                Email:<br>
                <input type="text" name="email" value="robin@somewhere.com" required>
                <br>
                Adgangskode:<br>
                <input type="password" name="password1" value="batman" required>
                <br>
                Adgangskode igen:<br>
                <input type="password" name="password2" value="batman" required>
                <br>
                Navn:<br>
                <input type="text" name="name" value="Robin Robinson" required>
                <br>
                Telefon nummer:<br>
                <input type="text" name="phonenumber" value="12345678" required>
                <br>
                Adresse:<br>
                <input type="text" name="address" value="verdensende" required>
                <br>

                <input type="submit" value="Registrer">
            </form>
        </td>
    </tr>
</table>
</body>
</html>