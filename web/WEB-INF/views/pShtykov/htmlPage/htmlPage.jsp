<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Test application by ShtykovPB aka Buranzo</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../css/htmlPage.css">
        <script src="../../js/createTable.js">
        </script>
    </head>
    <body>
        <div id="welcomeBlock" class="welcomeBlock">
            <hr width = '100%'>
            <div id="welcomeText" class="welcomeText"></div>
            <p>
                Количество столбцов
                <br>
                <input type="text" id="cols">
                <br>
                Количество строк
                <br>
                <input type="text" id="rows">
            </p>
            <input type="button" id="createTableButton" value="создать" onclick="fillTable(cols.value, rows.value)">
        </div>
        <div id="table"></div>
    </body>
</html>