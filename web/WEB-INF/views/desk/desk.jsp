<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Desk of StockManager by ShtykovPB aka Buranzo</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/desk.css">
    </head>
    <body>
        <h1 class="welcomeText">Projects</h1>
        <form action="/desk/addProject" method="GET">
            <table>
                <th></th>
                <tr>
                    <td>Project name</td>
                    <td>
                        <input class="input" type="text" name="projectName">
                    </td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <input class="input" type="text" name="type">
                    </td>
                </tr>
                <tr>
                    <td>Start date</td>
                    <td>
                        <input class="input" type="date" name="startDate">
                    </td>
                </tr>
                <tr>
                    <td>Finish date</td>
                    <td>
                        <input class="input" type="date" name="finishDate">
                    </td>
                </tr>
                <tr>
                    <td>Total amount</td>
                    <td>
                        <input class="input" type="text" name="totalAmount">
                    </td>
                </tr>
                <tr>
                    <td>vip</td>
                    <td>
                        <select class="input" name="vip">
                            <option>No</option>
                            <option>Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>user_id</td>
                    <td>
                        <select class="input" name="userId">
                            <option>select user id</option>
                            <c:forEach items="${users}" var="user">
                                <option><c:out value="${user.id}" /></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>state</td>
                    <td>
                        <select class="input" name="state">
                            <option>process</option>
                            <option>complete</option>
                        </select>
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="addProject" >
        </form>

        <hr>

        <table>
            <th  colspan = '10' class="titleTable"><b>Projects</b></th>
            <tr>
                <td class="titleTable">id</td>
                <td class="titleTable">projectName</td>
                <td class="titleTable">type</td>
                <td class="titleTable">startDate</td>
                <td class="titleTable">finishDate</td>
                <td class="titleTable">totalAmount</td>
                <td class="titleTable">vip</td>
                <td class="titleTable">state</td>
                <td class="titleTable">userId</td>
                <td class="titleTable">update</td>
                <td class="titleTable">delete</td>
            </tr>
            <c:forEach items="${projects}" var="project">
                <tr>
                <form action="/desk/updateStateProject" method="GET">
                    <td><input class="input" type="text" name="id" value=<c:out value="${project.id}" /> size="10"></td>
<!--                    <td><label class="input" for="id"><c:out value="${project.id}" /></td>-->
                    <td><input class="input" type="text" name="projectName" value=<c:out value="${project.projectName}" /> size="10"></td>
                    <td><input class="input" type="text" name="type" value=<c:out value="${project.type}" /> size="10"></td>
                    <td><input class="input" type="text" name="startDate" value=<c:out value="${project.startDate}" /> size="10"></td>
                    <td><input class="input" type="text" name="finishDate" value=<c:out value="${project.finishDate}" /> size="10"></td>
                    <td><input class="input" type="text" name="totalAmount" value=<c:out value="${project.totalAmount}" /> size="5"></td>
                    <td><input class="input" type="text" name="vip" value=<c:out value="${project.vip}" /> size="3"></td>
                    <td>
                        <select class="input" name="state" >
                            <option><c:out value="${project.state}" /></option>
                            <option>process</option>
                            <option>complete</option>
                        </select>
                        <!--<input class="input" type="text" name="state" value=<c:out value="${project.state}" />>-->
                    </td>
                    <td><input class="input" type="text" name="userId" value=<c:out value="${project.userId}" />></td>

<!--                    <td><c:out value="${project.projectName}" /></td>
             <td><c:out value="${project.type}" /></td>
             <td><c:out value="${project.startDate}" /></td>
             <td><c:out value="${project.finishDate}" /></td>
             <td><c:out value="${project.totalAmount}" /></td>
             <td><c:out value="${project.vip}" /></td>
             <td><c:out value="${project.state}" /></td>
             <td><c:out value="${project.userId}" /></td>-->
                    <td>
<!--                        <form action="/desk/updateStateProject/${project.id}" method="GET">-->
                        <input type="submit" value="updateState" >
                </form>
            </td>
            <td>
                <form action="/desk/deleteProject/${project.id}" method="GET">
                    <input type="submit" value="delete" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
