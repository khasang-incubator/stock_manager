<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<div id="Authors">
    <table>
        <th colspan="2"></th>
        <tr>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td><c:out value="${author.firstName}"/></td>
                <td><c:out value="${author.lastName}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<p>After deletion</p>
<div id="Survived">
    <table>
        <th colspan="2"></th>
        <tr>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
        </tr>
        <c:forEach items="${delete}" var="author">
            <tr>
                <td><c:out value="${author.firstName}"/></td>
                <td><c:out value="${author.lastName}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
