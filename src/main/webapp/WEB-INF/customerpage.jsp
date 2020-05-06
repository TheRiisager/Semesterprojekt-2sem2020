<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


        <h1>Hello ${sessionScope.email} </h1>

        <form name="Designpage" action="FrontController" method="POST">
            <input type="hidden" name="target" value="designpage">
            <input type="submit" value="Designside">
        </form>
        <form name="AccountPage" action="FrontController" method="POST">
            <input type="hidden" name="target" value="accountpage">
            <input type="submit" value="kontoside">
        </form>





        You are now logged in as a customer of our wonderful site.
<jsp:include page="footer.jsp"/>
