<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../script/users_script.js"></script>
    <link href="../css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
    <title>Title</title>
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
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/admin">Admin</a></li>
                <li><a href="/desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="/admin/backup">Backup</a></li>
                <li><a href="/admin/restore">Restore</a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <c:choose>
        <c:when test="${not empty error}">
            <p>Error, ${error}!</p>
        </c:when>
        <c:when test="${not empty backup}">
            <p>Backup was ${backup}</p>
        </c:when>
        <c:when test="${not empty restore}">
            <p>Restore was ${restore}</p>
        </c:when>
        <c:otherwise>
            <br>
        </c:otherwise>
    </c:choose>
    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
    <%--<h2>User: ${pageContext.request.userPrincipal.name}</h2>--%>
    <%--</c:if>--%>
    <table class="table" border="1" id="users_table">
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Логин</th>
            <th>Email</th>
            <th>Роль</th>
            <th>Удаление</th>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td class="id">${users.id}</td>
                <td class="firstName">${users.firstName}</td>
                <td class="lastName">${users.lastName}</td>
                <td class="login">${users.login}</td>
                <td class="email">${users.email}</td>
                <td class="role">${users.role}</td>
                <td><a href="/admin/delete?id=${users.id}">X</a></td>
            </tr>
        </c:forEach>
    </table>
    <form id="user_form" method="post">
        <h1>USER</h1>
        <br>
        <input type="text" name="id" hidden>
        <table class="table">
            <tr>
                <td><label>Name</label></td>
                <td><input type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td><label>Surname</label></td>
                <td><input type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td><label>Login</label></td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td><label>Role</label></td>
                <td>
                    <select name="role">
                        <option v>USER</option>
                        <option>ADMIN</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Password</label></td>
                <td><input type="text" name="password" id="password" style="visibility: hidden"/></td>
            </tr>
            <tr>
                <td><label>New user</label></td>
                <td><input type="checkbox" name="new_user" id="pass_checkbox"></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn btn-info" type="SUBMIT" value="Submit"></td>
            </tr>
        </table>
    </form>
    <c:url value="/logout" var="logoutUrl"/>
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
