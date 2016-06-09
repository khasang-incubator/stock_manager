<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <script src="../script/users_script.js"></script>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>User: ${pageContext.request.userPrincipal.name}</h2>
</c:if>

<a href="/admin/backup">Backup</a>
<a href="/admin/restore">Restore</a>
<a href="/admin/users">Users</a>
<a href="javascript:logoutSubmit()"> Logout</a>

<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>
