<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../script/users_script.js"></script>
    <link href="../css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
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
                <li><a href="/add_user">Registration</a></li>
                <li class="active"><a href="/admin">Admin</a></li>
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
        </div>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <br/>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Registered Users:</label></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-striped table-hover" id="users_table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Имя</th>
                                <th>Фамилия</th>
                                <th>Логин</th>
                                <th>Email</th>
                                <th>Роль</th>
                                <th>Удаление</th>
                            </tr>
                            </thead>
                            <tbody>
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
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Form for registration or update users:</label></div>
            <div class="panel-body">
                <div class="row">
                    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
                    <%--<h2>User: ${pageContext.request.userPrincipal.name}</h2>--%>
                    <%--</c:if>--%>
                    <div class="col-md-5">
                        <form id="user_form" method="post">
                            <input type="text" name="id" hidden>
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName"/>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName"/>
                            </div>
                            <div class="form-group">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" id="login" name="login"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" id="email" name="email"/>
                            </div>
                            <div class="form-group">
                                <label for="role">Role</label>
                                <select class="form-control" id="role" name="role">
                                    <option>ROLE_USER</option>
                                    <option>ROLE_ADMIN</option>
                                    <option>ROLE_SUPERADMIN</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" name="password" id="password"
                                       style="visibility: hidden"/>
                            </div>
                            <div class="check-box">
                                <label for="pass_checkbox">
                                    <input type="checkbox" name="new_user" id="pass_checkbox">
                                    New user
                                </label>
                            </div>
                            <button class="btn btn-default" type="SUBMIT">Submit</button>
                        </form>
                        <c:url value="/logout" var="logoutUrl"/>
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </div>
                </div>
            </div>
            <br/>
        </div>
        <div class="panel-heading" align="left"><label>Admin log:</label></div>
        <div class="panel-body">
            <div class="row">
                <div class="row">
                    <div class="col-md-5">
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
                                <p></p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
