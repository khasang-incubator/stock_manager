<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select table page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <style>
        table,th,td{
            border: 0.1px solid brown;
            padding: 0px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1 align="center">Wlogs table</h1>
<p style="text-align: center">View data from logs table</p>
<table>
    <c:forEach items="${wlogsContent}" var="tblRow">
    <tr>
        <td><c:out value="${tblRow.id}"/></td>
        <td><c:out value="${tblRow.occuredAt}"/></td>
        <td><c:out value="${tblRow.errorSource}"/></td>
        <td><c:out value="${tblRow.errorLevel}"/></td>
        <td><c:out value="${tblRow.errorDescription}"/></td>
    </tr>
                    </c:out>
    </table>
<h1 align="center">TypeError table</h1>
<tr>
    <th>ID</th>
    <th>ERROR_LEVEL</th>
    <th>CRITICAL</th>
</tr>
    <c:forEach items="${typeErrorContent}" var="tblRow">
        <tr align="center">
            <td><c:out value="${tblRow.id}"/></td>
            <td><c:out value="${tblRow.error_level}"/></td>
            <td><c:out value="${tblRow.critical}"/></td>
        </tr>
    </c:forEach>
</table>
<form action="/createtblQuestion">
    <p style="text-align: center">
        <button onclick="window.location.reload();">
    <p>Menu</p>
    <button type="submit">Назад</button>
</form>
</body>
</html>
