<%--
  Created by IntelliJ IDEA.
  Author: Christoffer
  Date: 21-04-2020
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="WEB-INF/header.jsp"/>

<div>
    <h2 style="color: #cc5274; text-align: center;">${nousererror}</h2>
    <p style="color: #cc5274; text-align: center;">${nousererror2}</p>
</div>

<div class="row container w-50" style="margin: 0 auto; color: white;">
    <div class="col w-auto" style="background-color: #014687; padding: 15px;">
        <h1>Login</h1>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="target" value="login">

            <div class="form-group">
                <label for="emailinput">Email:<br></label>
                <input type="email" name="email" value="robin@somewhere.com" id="emailinput" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="passinput">Adgangskode:</label>
                <input type="password" name="password" value="batman" id="passinput" class="form-control" required>
            </div>

            <input type="submit" value="Log ind" class="btn btn-primary">


        </form>
    </div>

    <div class="col w-auto" style="background-color: #cc1346; padding: 15px;">
        <h1>Register</h1>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="target" value="register">

            <div class="form-group">
                <label for="emailinput1">Email:<br></label>
                <input type="email" name="email" value="robin@somewhere.com" id="emailinput1" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="passinput1">Adgangskode:</label>
                <input type="password" name="password1" value="batman" id="passinput1" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="passinput2">Gentag adgangskode:</label>
                <input type="password" name="password2" value="batman" id="passinput2" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="nameinput">Navn:</label>
                <input type="text" name="name" value="Robin Robinson" id="nameinput" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="phoneinput">Telefonnummer:</label>
                <input type="text" name="phonenumber" value="Robin Robinson" id="phoneinput" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="addressinput">Adresse:</label>
                <input type="text" name="address" value="Robin Robinson" id="addressinput" class="form-control" required>
            </div>

            <input type="submit" value="Registrer" class="btn btn-primary">
        </form>
    </div>

</div>

<jsp:include page="WEB-INF/footer.jsp" />