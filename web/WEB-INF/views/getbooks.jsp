<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<div id="Books">
    <table>
        <th colspan="4"></th>
        <tr>
            <td>TITLE</td>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
            <td>SUBJECT</td>
        </tr>
        <c:forEach items="${getBooks}" var="book">
            <tr>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author.firstName}"/></td>
                <td><c:out value="${book.author.lastName}"/></td>
                <td><c:out value="${book.subject.subject}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
