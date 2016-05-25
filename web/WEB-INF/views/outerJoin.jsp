<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OuterJoinGoods</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<p style="text-align: center">View Goods</p>
<table align="center">
    <tr>
        <th>ID</th>
        <th>GOODS</th>
    </tr>
    <c:forEach items="${outerJoin}" var="dataexample">
        <tr>
            <td><c:out value="${dataexample.ID}"/></td>
            <td><c:out value="${dataexample.goods}"/></td>
        </tr>
    </c:forEach>
</table>
<form>
    <p style="text-align: center">
        <button onclick="window.location.reload();">
    <p>Menu</p>
    <button onclick="window.location.reload();"><p>Select</p></button>
    <button onclick="window.location.reload();"><p>Logoff</p></button>
</form>
</body>
</html>
