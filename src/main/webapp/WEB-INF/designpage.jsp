<%--
  Created by IntelliJ IDEA.
  User: Ali Raid Tahir
  Date: 21-04-2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<h1> Carport creation page</h1>

<a href="FrontController?target=drawing">See drawing</a>

<body>

<form oninput="x.value=parseInt(a.value)*parseInt(b.value)">
    <h2> Insert height here</h2>
    <input type="number" id="a" value=""><br>
    <h2> Insert length here</h2>
    <input type="number" id="b" value=""><br>
    <h2> insert width here</h2>
    <input type="number" id="c" value=""><br>
    <h2> The volume of your carport is</h2>
    <output name="x"  for="a b "></output>m^2


</form>
<br>
<form name="savedesign" action="FrontController" method="POST">
    <input type="hidden" name="target" value="savedesign">
    <h2> Insert length here</h2>
    <input type="number" name= "length" value = ""><br>
    <h2> insert width here</h2>
    <input type="number" name="width" value="" ><br>
    <h2> The volume of your carport is</h2>
    <input type="submit" value="Gem design">


</form>
</body>

</html>
