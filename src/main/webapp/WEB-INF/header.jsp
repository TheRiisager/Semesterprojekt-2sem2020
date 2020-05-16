<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog carport</title>

        <style>
            body {
                background-color: white;
                background-image: url("img/bg.jpg");
                background-size: cover;

            }

            .navbar-nav {
                float:none;
                margin:0 auto;
                display: block;
                text-align: center;
            }
        </style>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <form name="index" action="FrontController" method="POST">
                        <input type="hidden" name="target" value="home">
                        <input type="submit" value="Hjem" class="nav-link" style="border: none; background: none; text-decoration: none;">
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.johannesfog.dk/byggecenter/have--fritid/byg-selv-produkter/?id=31893">Carporte</a>
                </li>
                <li class="nav-item">
                    <form name="index" action="FrontController" method="POST">
                        <input type="hidden" name="target" value="designpage">
                        <input type="submit" value="Byg Selv" class="nav-link" style="border: none; background: none; text-decoration: none;">
                    </form>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.email != null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.email}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <c:set var = "customer" scope = "request" value = "customer"/>
                                <c:choose>
                                    <c:when test="${sessionScope.role == customer}">
                                        <form name="index" action="FrontController" method="POST">
                                            <input type="hidden" name="target" value="accountpage">
                                            <input type="submit" value="Konto" class="dropdown-item" style="border: none; background: none; text-decoration: none;">
                                        </form>
                                    </c:when>
                                </c:choose>
                                <form name="index" action="FrontController" method="POST">
                                    <input type="hidden" name="target" value="logout">
                                    <input type="submit" value="Log ud" class="dropdown-item" style="border: none; background: none; text-decoration: none;">
                                </form>
                            </div>
                        </li>
                    </c:when>
                </c:choose>

            </ul>
        </div>
    </nav>
        <div class="container-fluid" style="margin-top: 6%; margin-bottom: 5%;">