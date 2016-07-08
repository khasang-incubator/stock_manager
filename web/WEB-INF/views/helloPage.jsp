<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome to StackManager</title>
    <link href="css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">StockManager</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/add_user">Registration</a></li>
                <li><a href="/admin">Admin</a></li>
                <li><a href="/desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
                <li><a href="/point">Map</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.authenticated}">
                        <li><a href="/admin/backup">Backup</a></li>
                        <li><a href="/admin/restore">Restore</a></li>
                    </c:when>
                </c:choose>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <h1>Current User</h1>
    <p>${username}</p>
    <h1>Encrypt password</h1>
    <p>${crypt}</p>
</div>

</body>
</html>
