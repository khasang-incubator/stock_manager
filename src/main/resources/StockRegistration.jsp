
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bodyStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/buttonsStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/headerStyle.css"/>
    <style>

    </style>
</head>
<body>
<div class="container">
    <h1 id="header1" class="header1">
        <span class="letter">Stock manager</span>
    </h1>
    <div class="row text-left">
<sf:form method="POST" commandName="StockRegistration">
    <table class = "table">
        <tr>
            <td align="left"><sf:label path="firstName">First Name</sf:label>:
                <sf:input path="firstName"/></td>
            <td align="left"><form:errors path="firstName" cssClass="error" /></td>
        </tr>
        <tr>
            <td align="left"><sf:label path="lastName">Last Name</sf:label>:
                <sf:input path="lastName"  /></td>
            <td align="left"><form:errors path="lastName" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td align="left"><sf:label path="email">Email:</sf:label><sf:input type="email" path="email" /></td>
            <td align="left"><form:errors path="email" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td align="left"><sf:label path="userName">Username</sf:label>:
                <sf:input path="userName" /></td>
            <td align="left"><form:errors path="userName" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td align="left"><sf:label path="password">Password</sf:label>:
                <sf:input path="password"/></td>
            <td align="left"><form:errors path="password" cssClass="error" />
            </td>

        </tr>

        <tr>
            <td colspan="3">
    <input type="submit" value="Register" />
            </td>
        </tr>
    </table>
</sf:form>
    </div>
    <footer class="container">
        <div class="row">
            <p class="col-sm-4">
                &copy; 2016 Khasang Students Project
            </p>
            <ul class="col-sm-8">
            </ul>
        </div>
    </footer>
</div>
</body>
</html>
