<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Desk</title>
        <meta charset="UTF-8">
        <!--        <link rel="stylesheet" href="css/io.khasang.stockmanager.dao.desk.css">-->
        <!--<link rel="stylesheet" href="css/desk.css">-->
        <!--<link href="css/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet"  type="text/css" media="all">-->

        <link rel="stylesheet" href="css/bootstrap-3.3.6-dist/css/bootstrap.min.css" type="text/css" media="all">

        <!--         Optional theme
                <link rel="stylesheet" href="css/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css" type="text/css" media="all">-->
        
        <script src="css/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->


                <script src="js/availableStateProject.js">
                </script>
    </head>
    <body>

        <div class="panel panel-default">
            <div class="panel-heading"><H1 class="text-info">Desk</h1></div>
            <div class="panel-body">


<!--                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">HTML</a></li>
                        <li><a href="#">CSS</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </div>-->


                <!--                <div class="panel-group" id="collapse-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#collapse-group" href="#el1">Первый элемент</a>
                                            </h4>
                                        </div>
                                        <div id="el1" class="panel-collapse collapse in">
                                            <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</div>
                                        </div>
                                    </div>
                                </div>-->



                <table id="pageTable" class="table">
                    <tr>
                        <td>

                            <!--ADD PROJECT BLOCK-->
                            <!--                            <form action="/io.khasang.stockmanager.dao.desk/addProject" method="GET">-->
                            <form action="desk/addProject" method="GET">
                                <table id="addProjectTable" class="table table-hover table-bordered">
                                    <th  colspan = '2'><b>add Project</b></th>
                                    <tr>
                                        <td>Project name</td>
                                        <td>
                                            <input type="text" name="projectName">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Type</td>
                                        <td>
                                            <input type="text" name="type">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Start date</td>
                                        <td>
                                            <input type="date" name="startDate">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Finish date</td>
                                        <td>
                                            <input type="date" name="finishDate">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Total amount</td>
                                        <td>
                                            <input type="text" name="totalAmount">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Vip</td>
                                        <td>
                                            <select class="form-control" name="vip">
                                                <option>No</option>
                                                <option>Yes</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>User id</td>
                                        <td>
                                            <select class="form-control" name="userId">
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
                                            <select class="form-control" name="state">
                                                <option>process</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><input class="btn btn-info" type="submit" value="addProject" ></td>
                                    </tr>
                                </table>
                                <br>
                            </form>
                        </td>
                        <td>
                            <!--VIEW PROJECTS BLOCK-->
                            <c:if test="${fn:length(projects) > 0}">
                                <table id="viewProjectsTable" class="table table-striped table-hover table-bordered">
                                <th  colspan = '11'><b>Projects</b></th>
                                <tr>
                                    <td>id</td>
                                    <td>projectName</td>
                                    <td>type</td>
                                    <td>startDate</td>
                                    <td>finishDate</td>
                                    <td>totalAmount</td>
                                    <td>vip</td>
                                    <td>state</td>
                                    <td>userId</td>
                                    <td>update</td>
                                    <td>delete</td>
                                </tr>
                                    <c:forEach items="${projects}" var="project">
                                        <tr>
                                        <form name="stateProjectForm" action="desk/updateStateProject" method="GET">
                                            <td><input type="text" name="id" value=<c:out value="${project.id}" /> size="5"></td>
                                            <td><input type="text" name="projectName" value=<c:out value="${project.projectName}" /> size="10"></td>
                                            <td><input type="text" name="type" value=<c:out value="${project.type}" /> size="10"></td>
                                            <td><input type="text" name="startDate" value=<c:out value="${project.startDate}" /> size="10"></td>
                                            <td><input type="text" name="finishDate" value=<c:out value="${project.finishDate}" /> size="10"></td>
                                            <td><input type="text" name="totalAmount" value=<c:out value="${project.totalAmount}" /> size="5"></td>
                                            <td><input type="text" name="vip" value=<c:out value="${project.vip}" /> size="3"></td>
                                            <td>
                                                <select class="form-control" id="state" name="state">
                                                    <option><c:out value="${project.state}" /></option>
                                                </select>
                                            </td>
                                            <td><input type="text" name="userId" value=<c:out value="${project.userId}" /> size="5"></td>
                                            <td>
                                                <input class="btn btn-info" type="submit" value="update" >
                                            </td>
                                        </form>
                                        <form action="desk/deleteProject/${project.id}" method="GET">
                                            <td>
                                                <input class="btn btn-info" type="submit" value="delete" >
                                            </td>
                                        </form>
                            </tr>
                            </c:forEach>
                </table>
                                </c:if>
                </td>
                </tr>

                <!--SEPARATOR-->
                <tr><td" colspan="2"><hr></td></tr>

                <tr>
                    <td>

                        <!-- ADD PROJECT PRODUCT BLOCK-->
                        <form action="desk/addProjectProduct" method="GET">
                            <table id="addProjectProductTable" class="table table-hover table-bordered">
                                <th  colspan = '2'><b>add ProjectProduct</b></th>
                                <tr>
                                    <td>Project id</td>
                                    <td>
                                        <select class="form-control" name="projectId">
                                            <option>select project id</option>
                                            <c:forEach items="${projects}" var="project">
                                                <option><c:out value="${project.id}" /></option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Product id</td>
                                    <td>
                                        <select class="form-control" name="productId">
                                            <option>select product id</option>
                                            <c:forEach items="${products}" var="product">
                                                <option><c:out value="${product.id}" /></option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                <td>Quantity</td>
                                <td>
                                    <input type="text" name="quantity">
                                </td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td>
                                        <input type="text" name="price">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Amount</td>
                                    <td>
                                        <input type="text" name="amount">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Purchase date</td>
                                    <td>
                                        <input type="date" name="purchaseDate">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input class="btn btn-info" type="submit" value="addProjectProduct" ></td>
                                </tr>
                            </table>
                        </form>
                    </td>
                    <td>

                        <!--VIEW PROJECTS_PRODUCTS BLOCK-->
                        <c:if test="${fn:length(projectsProducts) > 0}">
                            <table id="viewProjectsProductsTable" class="table table-striped table-hover table-bordered">
                                <th  colspan = '7'><b>ProjectsProducts</b></th>
                                <tr>
                                    <td>id</td>
                                    <td>projectId</td>
                                    <td>quantity</td>
                                    <td>price</td>
                                    <td>amount</td>
                                    <td>purchaseDate</td>
                                    <td>delete</td>
                                </tr>

                                <tr>
                                    <c:forEach items="${projectsProducts}" var="projectProducts">
                                        <td><input type="text" name="id" value=<c:out value="${projectProducts.id}" /> size="5"></td>
                                        <td><input type="text" name="projectId" value=<c:out value="${projectProducts.projectId}" /> size="5"></td>
                                        <td><input type="text" name="quantity" value=<c:out value="${projectProducts.quantity}" /> size="5"></td>
                                        <td><input type="text" name="price" value=<c:out value="${projectProducts.price}" /> size="5"></td>
                                        <td><input type="text" name="amount" value=<c:out value="${projectProducts.amount}" /> size="5"></td>
                                        <td><input type="text" name="purchaseDate" value=<c:out value="${projectProducts.purchaseDate}" /> size="10"></td>
                                    <form action="desk/deleteProjectProduct/${projectProducts.id}" method="GET">
                                        <td>
                                            <input class="btn btn-info" type="submit" value="delete" >
                                        </td>
                                    </form>
                        </tr>
                    </c:forEach>
                    </table>
                </c:if>
                </td>
                </tr>
                </table>
            </div>
        </div>

        <!--PAGE FOOTER-->
        <div class="panel-footer">Panel footer</div>
    </body>
</html>