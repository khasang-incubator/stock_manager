<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="/">Home</a>
<div class="container">
    <sf:form method="POST" commandName="user">
        <table class="table">
            <thead>
            <tr>
                <th>Input user registration info</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>First Name:</td>
                <td><sf:input path="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><sf:input path="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><sf:input type="email" path="email"/></td>
                <td><form:errors path="email" cssClass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><sf:input path="login"/></td>
                <td><form:errors path="login" cssClass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><sf:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"></form:errors></td>
            </tr>
            </tr>
            <tr>
                <td>Role:</td>
                <td><sf:input path="role"/></td>
                <td><form:errors path="role" cssClass="error"></form:errors></td>
            </tr>
            </tbody>
            <input type="submit" value="Register"/>
        </table>
    </sf:form>
</div>
</body>
</html>
