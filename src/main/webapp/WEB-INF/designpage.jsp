<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>



<form name="savedesign" action="FrontController" method="POST" oninput="x.value=Math.round( ( parseInt(a.value) / 100 ) * ( parseInt(b.value) / 100 ) )">

    <input type="hidden" name="target" value="savedesign">
    <div class="form-group">
        <select name="width" id="a" class="form-control col-md-3">
            <c:forEach items="${widthlengthoptions}" var="width">
                <option value="${width}">
                        ${width}cm
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <select name="length" id="b" class="form-control col-md-3">
            <c:forEach items="${widthlengthoptions}" var="length">
                <option value="${length}">
                        ${length}cm
                </option>
            </c:forEach>
        </select>
    </div>
    <h2> Din carports areal er: <output name="x"  for="a b"></output>m2</h2>

    <input type="submit" value="Gem design">
</form>






<jsp:include page="footer.jsp"/>


