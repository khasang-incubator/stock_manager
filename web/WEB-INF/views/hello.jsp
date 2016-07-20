<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome to StackManager</title>
    <link href="css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="js/logout.js"></script>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="activeId" value="homeMenuItem"/>
</jsp:include>
<div class="container">
    <div class="starter-template">
        <br>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Welcome to StockManager</label></div>
            <div class="panel-body">
                <div class="row">
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.authenticated}">You are logged in as
                            <b>${pageContext.request.userPrincipal.name}</b></c:when>
                        <c:otherwise>
                            <form name='loginForm' action="<c:url value='/' />" method='POST' class="form-inline">
                                <label for="focusedInput">User:</label>
                                <input type='text' name='username' value="admin" class="form-control">
                                <label for="focusedInput">Password:</label>
                                <input type='password' name='password' value="admin" class="form-control"
                                       id="focusedInput"/>
                                <input name="submit" type="submit" value="Login"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
