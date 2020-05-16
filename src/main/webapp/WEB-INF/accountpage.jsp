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
    <input type="submit" value="Opdater info">
</form>

<div class="row">
    <c:set var = "gridcount" scope = "page" value = "${0}"/>
    <c:forEach var="order" items="${sessionScope.orderslist}">
        <div class="col">
            <form>
                <input type="hidden" name="target" value="showOrder">
                <input type="hidden" name="oid" value="${order.getOrderID()}">
                <button style="text-decoration: none; background: none; outline: none; border: none;">
                    <div style="border-radius: 10px;
                        <c:choose>
                            <c:when test="${order.getStatus() == 0}">
                                background-color: #cc1346;
                            </c:when>

                            <c:when test="${order.getStatus() == 1}">
                                background-color: gold;
                            </c:when>

                            <c:when test="${order.getStatus() == 2}">
                                background-color: lightgreen;
                            </c:when>
                        </c:choose>;
                    text-align: left; padding: 10px; color: white; margin: 10px;">
                        <h1 class="font-weight-bold">#${order.getOrderID()}</h1>
                        <p>Længde: ${order.getCarportLength()} bredde: ${order.getCarportWidth()}</p>
                        <c:choose>
                            <c:when test="${order.getStatus() == 0}">
                                <p>Din order afventer bekræftelse.</p>
                            </c:when>

                            <c:when test="${order.getStatus() == 1}">
                                <p>Din order bliver bekræftet af en sælger.</p>
                            </c:when>

                            <c:when test="${order.getStatus() == 2}">
                                <p>Din order er bekræftet, og behandles nu.</p>
                            </c:when>
                        </c:choose>
                    </div>
                </button>
            </form>
        </div>
        <c:set var = "gridcount" scope = "page" value = "${gridcount+1}"/>
        <c:if test="${gridcount % 4 == 0}">
            <div class="w-100"></div>
        </c:if>
    </c:forEach>
</div>
<jsp:include page="footer.jsp"/>
