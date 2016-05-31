<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../css/examplepage.css">
</head>
<body>
<div id="container">
    <div id="header">
        <p>Действия с join</p>
    </div>

    <div id="add_item">

    </div>

    <div id="container_for_table">
        <table id="table_with_items" border="1">
            <tr>
                <th class="id_of_item">ID</th>
                <th class="name_of_item">Наименование</th>
                <th class="cost_of_item">Владелец</th>
                <th class="cost_of_item">Почта</th>
            </tr>
            <c:forEach items="${items}" var="stockitems">
                <tr>
                    <td><c:out value="${stockitems.id}"/></td>
                    <td><c:out value="${stockitems.name}"/></td>
                    <td><c:out value="${stockitems.name_owner}"/></td>
                    <td><c:out value="${stockitems.email}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="buttons">

    </div>
</div>
</body>
</html>