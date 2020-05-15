<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 10-05-2020
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
        ${sessionScope.svg}
        <p>Samlet pris: ${sessionScope.totalPrice}</p>
<jsp:include page="footer.jsp"/>
