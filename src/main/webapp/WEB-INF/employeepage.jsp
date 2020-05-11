<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
        <table class="table table-hover" style="width: 75%;">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Dimensioner</th>
                </tr>
            </thead>
        </table>
            <c:forEach var="order" items="${orderList}">
                <form>
                    <input type="hidden" name="target" value="showOrder">
                    <input type="hidden" name="oid" value="${order.getOrderID()}">
                    <button type="submit" class="w-75" style="border: none; text-decoration: none; background: none; margin-top: 0px;">
                        <table class="table table-hover text-left">
                            <tr>
                                <td class="w-25">${order.getOrderID()}</td>
                                <td class="w-75">${order.getCarportLength()}x${order.getCarportWidth()}</td>
                            </tr>
                        </table>
                    </button>
                </form>
            </c:forEach>
<jsp:include page="footer.jsp"/>
