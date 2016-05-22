<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>JDBC application by ShtykovPB aka Buranzo</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../css/jdbcPage.css">
        <script src="../js/createTable.js">
        </script>
    </head>
    <body>
        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Drop & Create tables.</div>
            <p class="resultTextTrue">
                result: ${createTables}
            </p>
        </div>

        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Fill testing data.</div>
            <p class="resultTextTrue">
                result: ${fillData}
            </p>
        </div>

        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Select.</div>
            <table>
                <c:forEach items="${select}" var="employees">
                    <tr>
                        <td><c:out value="${employees.id}" /></td>
                        <td><c:out value="${employees.employee}" /></td>
                        <td><c:out value="${employees.room}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>