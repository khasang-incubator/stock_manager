<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.05.2016
  Time: 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="stockpage">
</head>
<body>
<div id="container">
    <div id="header">
        <h1>Main Information</h1>
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
            </tr>
            ${showtable}
        </table>
    </div>

    <div id="buttons">

    </div>
</div>
</body>
</html>
