<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Логин</th>
        <th>Email</th>
        <th>Роль</th>
    </tr>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.id}</td>
            <td>${users.name}</td>
            <td>${users.login}</td>
            <td>${users.email}</td>
            <td>${users.role}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
