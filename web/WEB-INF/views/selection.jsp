<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET SELECTION</title>
</head>
<body>
<h1>Company Names</h1>
<div id="companyName">
    <c:forEach items="${selection}" var="companyName">
        <p><c:out value="${companyName}"/></p>
    </c:forEach>
</div>
</body>
</html>
