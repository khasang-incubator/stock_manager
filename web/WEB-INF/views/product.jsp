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
<hr>
<form:form method="post" action="add" commandName="product">
    <table>
        <tr>
            <td valign="bottom">Новый:</td>
            <td>Наименование:<br>
            <form:input path="name" /></td>
            <td>Описание:<br>
            <form:input path="description" /></td>
            <td valign="bottom"><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form:form>
<hr>
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
