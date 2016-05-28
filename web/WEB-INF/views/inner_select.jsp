<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inner select</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<table id="resultTable" border='1'>
    <caption><h3>Inner select</h3></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Provider ID</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.providerId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
