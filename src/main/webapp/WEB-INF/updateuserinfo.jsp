<%--
  Created by IntelliJ IDEA.
  User: Ali Raid Tahir
  Date: 28-04-2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<form name="User" action="FrontController" method="post">
    <input type="hidden" name="target" value="updateuserinfo">
    Navn: <br>
    <input type="text" name="name" value=${sessionScope.name} required>
    <br>
    TelefonNummer: <br>
    <input type="number" name="phonenumber" value=${sessionScope.phonenumber} required>
    <br>
    addresse: <br>
    <input type="text" name="address" value=${sessionScope.address} required>
    <br>
    <input type="submit" value="Opdater info">
    

</form>
<jsp:include page="footer.jsp"/>