<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>JDBC application by ShtykovPB aka Buranzo</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/jdbcPage.css">
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

        <br>
        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Filling test data.</div>
            <p class="resultTextTrue">
                result: ${fillData}
            </p>
        </div>

        <br>
        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Select.</div>
            <table>
                <th  colspan = '3' class="titleTable"><b>Table Employees</b></th>
                <tr>
                    <td class="titleTable">ID</td>
                    <td class="titleTable">Employee</td>
                    <td class="titleTable">Room</td>
                </tr>
                <c:forEach items="${selectEmployees}" var="employees">
                    <tr>
                        <td><c:out value="${employees.id}" /></td>
                        <td><c:out value="${employees.employee}" /></td>
                        <td><c:out value="${employees.room}" /></td>
                    </tr>
                </c:forEach>
            </table>
            <table>
                <th  colspan = '3' class="titleTable"><b>Table Departments</b></th>
                <tr>
                    <td class="titleTable">ID</td>
                    <td class="titleTable">Room</td>
                    <td class="titleTable">Department</td>
                </tr>
                <c:forEach items="${selectDepartments}" var="department">
                    <tr>
                        <td><c:out value="${department.id}" /></td>
                        <td><c:out value="${department.room}" /></td>
                        <td><c:out value="${department.department}" /></td>
                    </tr>
                </c:forEach>
            </table>
            
        </div>

        <br>
        <hr width = '100%'>
        <div id="textBlock" class="textBlock">
            <div id="titleTextBlock" class="titleTextBlock">Full OuterJoin.</div>
            <table>
<!--                <tr><td colspan = '4' class="titleTable"><b>Full Outer Join table</b></td></tr>-->
<th  colspan = '4' class="titleTable"><b>Full Outer Join table</b></th>
                <tr>
                    <td class="titleTable">Employee</td>
                    <td class="titleTable">EmployeeRoom</td>
                    <td class="titleTable">DepartmentRoom</td>
                    <td class="titleTable">Department</td>
                </tr>
                <c:forEach items="${selectOuterJoin}" var="employeesDepartments">
                    <tr>
                        <td><c:out value="${employeesDepartments.employee.employee}" /></td>
                        <td><c:out value="${employeesDepartments.employee.room}" /></td>
                        <td><c:out value="${employeesDepartments.department.room}" /></td>
                        <td><c:out value="${employeesDepartments.department.department}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>