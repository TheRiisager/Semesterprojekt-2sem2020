<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <body>
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
                    <input type="hidden" name="target" value="salesOrderView">
                    <input type="hidden" name="oid" value="${order.getOrderID()}">
                    <button type="submit" class="w-75" style="border: none; text-decoration: none; background: none; margin-top: 0px;">
                        <table class="table table-hover text-left">
                            <tr>
                                <td class="w-25">${order.getOrderID()}</td>
                                <td class="w-75">${order.getCarportLength()}x${order.getCarportWidth()}x${order.getCarportHeight()}</td>
                            </tr>
                        </table>
                    </button>
                </form>
            </c:forEach>
    </body>
</html>
