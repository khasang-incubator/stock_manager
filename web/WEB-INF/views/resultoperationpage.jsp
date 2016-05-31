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
        <p>${result}</p>
    </div>

    <div id="add_item">

    </div>

    <div id="container_for_table">
        <table id="table_with_items" border="1">
            <tr>
                <th class="id_of_item">ID</th>
                <th class="name_of_item">Наименование</th>
                <th class="sizes_of_item">Размеры(если актуально)</th>
                <th class="unit_of_item">Единица измерения</th>
                <th class="quantity_of_item">Количество</th>
                <th class="cost_of_item">Стоимость</th>
                <th class="cost_of_item">Владелец</th>
            </tr>
            <c:forEach items="${items}" var="stockitems">
                <tr>
                    <td><c:out value="${stockitems.id}"/></td>
                    <td><c:out value="${stockitems.name}"/></td>
                    <td><c:out value="${stockitems.size}"/></td>
                    <td><c:out value="${stockitems.unit}"/></td>
                    <td><c:out value="${stockitems.quantity}"/></td>
                    <td><c:out value="${stockitems.cost}"/></td>
                    <td><c:out value="${stockitems.owner_id}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="buttons">

    </div>
</div>
</body>
</html>