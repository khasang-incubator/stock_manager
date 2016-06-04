<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../script/users_script.js"></script>
    <title>Title</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>User: ${pageContext.request.userPrincipal.name}</h2>
</c:if>
<a href="/admin">Back</a>
<a href="javascript:logoutSubmit()">Logout</a><br>
<table border="1" id="users_table">
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
            <td class="name">${users.name}</td>
            <td class="surname">${users.surname}</td>
            <td class="login">${users.login}</td>
            <td class="email">${users.email}</td>
            <td class="role">${users.role}</td>
            <td><a href="delete?id=${users.id}">X</a></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${not empty error}">
    <p>Error, ${error}!</p>
</c:if>
<form id="user_form" method="post">
    <h1>USER</h1>
    <br>
    <input type="text" name="id" hidden>
    <label>Name</label>
    <input type="text" name="name"/>
    <br>
    <label>Surname</label>
    <input type="text" name="surname"/>
    <br>
    <label>Login</label>
    <input type="text" name="login"/>
    <br>
    <label>Email</label>
    <input type="text" name="email"/>
    <br>
    <label>Role</label>
    <select name="role">
        <option v>USER</option>
        <option>ADMIN</option>
    </select>
    <br>
    <label>Password</label>
    <input type="text" name="password" id="password" style="visibility: hidden"/>
    <br>
    <input type="SUBMIT" value="Submit">
    <label>New user</label>
    <input type="checkbox" name="new_user" id="pass_checkbox">
</form>
<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
</body>
</html>
