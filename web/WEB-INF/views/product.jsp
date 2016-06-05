<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Справочник продуктов</h3>
<c:if test="${!empty productList}">
    <table class="data">
        <tr>
            <th>ID</th>
            <th>Наименование</th>
            <th>Описание</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td><a href="delete/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
