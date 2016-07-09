<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Desk</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css" media="all">
    <script src="../../bootstrap/js/bootstrap.min.js"></script>
    <link href="css/starter-template.css" rel="stylesheet">
    <script src="../../js/availableStateProject.js"></script>
    <script src="../js/users_script.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">StockManager</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/add_user">Registration</a></li>
                <li><a href="/admin">Admin</a></li>
                <li class="active"><a href="/desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
                <li><a href="/point">Map</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <br/>
        <%--panel project--%>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Add new project</label></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-12"><!--
                                <!--ADD PROJECT BLOCK-->
                        <form action="desk/addProject" method="GET" role="form">
                            <div class="col-md-6">
                                <div class="controls">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="projectName">Project name:</label>
                                                <input id="projectName" type="text" name="projectName"
                                                       class="form-control" placeholder="project name">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="type">Type:</label>
                                                <input id="type" type="text" name="type" class="form-control"
                                                       placeholder="project type">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="startDate">Start date:</label>
                                                <input id="startDate" type="date" name="startDate"
                                                       class="form-control" placeholder="yyyy-mm-dd">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="finishDate">Finish date:</label>
                                                <input id="finishDate" type="date" name="finishDate"
                                                       class="form-control" placeholder="yyyy-mm-dd">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-groupcontrol-group">
                                                <label for="totalAmount">Total amount:</label>
                                                <input id="totalAmount" type="text" name="totalAmount"
                                                       class="form-control" placeholder="Total amount">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="vip">Vip:</label>
                                                <select class="form-control" name="vip" class="form-control"
                                                        placeholder="Vip">
                                                    <option>No</option>
                                                    <option>Yes</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="userId">User id:</label>
                                                <select class="form-control" name="userId" class="form-control"
                                                        placeholder="User id">
                                                    <option>select user id</option>
                                                    <c:forEach items="${users}" var="user">
                                                        <option><c:out value="${user.id}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="state">State:</label>
                                                <select class="form-control" name="state" class="form-control"
                                                        placeholder="State">
                                                    <option>process</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <input class="btn btn-primary btn-block" type="submit" value="add project"></td>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <!--VIEW PROJECTS BLOCK-->
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <c:if test="${fn:length(projects) > 0}">
                                <table id="viewProjectsTable"
                                       class="table table-striped table-hover table-bordered table-condensed">
                                    <th colspan='11'>
                                        <div class="text-center">Projects</div>
                                    </th>
                                    <tr>
                                        <td class="text-center">id</td>
                                        <td class="text-center">projectName</td>
                                        <td class="text-center">type</td>
                                        <td class="text-center">startDate</td>
                                        <td class="text-center">finishDate</td>
                                        <td class="text-center">totalAmount</td>
                                        <td class="text-center">vip</td>
                                        <td class="text-center">state</td>
                                        <td class="text-center">userId</td>
                                        <td class="text-center">update</td>
                                        <td class="text-center">delete</td>
                                    </tr>
                                    <c:forEach items="${projects}" var="project">
                                        <tr>
                                            <form name="stateProjectForm" action="desk/updateStateProject" method="GET">
                                                <td class="text-center"><input type="text" name="id" value=
                                                    <c:out value="${project.id}"/> size="3"></td>
                                                <td class="text-center"><input type="text" name="projectName" value=
                                                    <c:out value="${project.projectName}"/> size="7"></td>
                                                <td class="text-center"><input type="text" name="type" value=
                                                    <c:out value="${project.type}"/> size="7"></td>
                                                <td class="text-center"><input type="text" name="startDate" value=
                                                    <c:out value="${project.startDate}"/> size="10"></td>
                                                <td class="text-center"><input type="text" name="finishDate" value=
                                                    <c:out value="${project.finishDate}"/> size="10"></td>
                                                <td class="text-center"><input type="text" name="totalAmount" value=
                                                    <c:out value="${project.totalAmount}"/> size="5"></td>
                                                <td class="text-center"><input type="text" name="vip" value=
                                                    <c:out value="${project.vip}"/> size="3"></td>
                                                <td class="text-center">
                                                    <select class="form-control" id="state" name="state">
                                                        <option><c:out value="${project.state}"/></option>
                                                    </select>
                                                </td>
                                                <td class="text-center"><input type="text" name="userId" value=
                                                    <c:out value="${project.userId}"/> size="3"></td>
                                                <td class="text-center">
                                                    <input class="btn btn-info" type="submit" value="update">
                                                </td>
                                            </form>
                                            <form action="desk/deleteProject/${project.id}" method="GET">
                                                <td class="text-center">
                                                    <input class="btn btn-info" type="submit" value="delete">
                                                </td>
                                            </form>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-------------SEPARATOR--------------->
        <br/>
        <%--panel project-product--%>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Add new project–product</label></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-12">
                        <!--ADD PROJECT–PRODUCT BLOCK-->
                        <form action="desk/addProjectProduct" method="GET" role="form">
                            <div class="col-md-6">
                                <div class="controls">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="projectId">Project id:</label>
                                                <select class="form-control" name="projectId">
                                                    <option>select project id</option>
                                                    <c:forEach items="${projects}" var="project">
                                                        <option><c:out value="${project.id}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="productId">Product id:</label>
                                                <select class="form-control" name="productId">
                                                    <option>select product id</option>
                                                    <c:forEach items="${products}" var="product">
                                                        <option><c:out value="${product.id}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="quantity">Quantity:</label>
                                                <input id="quantity" type="text" name="quantity"
                                                       class="form-control"
                                                       placeholder="quantity">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="price">Price:</label>
                                                <input id="price" type="text" name="price" class="form-control"
                                                       placeholder="price">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-groupcontrol-group">
                                                <label for="amount">Amount:</label>
                                                <input id="amount" type="text" name="amount" class="form-control"
                                                       placeholder="amount">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="purchaseDate">Purchase date:</label>
                                                <input id="purchaseDate" type="date" name="purchaseDate"
                                                       class="form-control" placeholder="yyyy-mm-dd">
                                            </div>
                                        </div>
                                    </div>
                                    <input class="btn btn-primary btn-block" type="submit"
                                           value="add project-product"></td>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">

                    <!--VIEW PROJECTS–PRODUCTS BLOCK-->
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <c:if test="${fn:length(projects) > 0}">
                                <table id="viewProjectsProductsTable"
                                       class="table table-striped table-hover table-bordered table-condensed">
                                    <th colspan='7'>
                                        <div class="text-center">Projects–Products</div>
                                    </th>
                                    <tr>
                                        <td class="text-center">id</td>
                                        <td class="text-center">projectId</td>
                                        <td class="text-center">quantity</td>
                                        <td class="text-center">price</td>
                                        <td class="text-center">amount</td>
                                        <td class="text-center">purchaseDate</td>
                                        <td class="text-center">delete</td>
                                    </tr>
                                    <c:forEach items="${projectsProducts}" var="projectProducts">
                                        <tr>
                                            <td class="text-center"><input type="text" name="id" value=
                                                <c:out value="${projectProducts.id}"/> size="3"></td>
                                            <td class="text-center"><input type="text" name="projectId" value=
                                                <c:out value="${projectProducts.projectId}"/> size="3"></td>
                                            <td class="text-center"><input type="text" name="quantity" value=
                                                <c:out value="${projectProducts.quantity}"/> size="3"></td>
                                            <td class="text-center"><input type="text" name="price" value=
                                                <c:out value="${projectProducts.price}"/> size="5"></td>
                                            <td class="text-center"><input type="text" name="amount" value=
                                                <c:out value="${projectProducts.amount}"/> size="5"></td>
                                            <td class="text-center"><input type="text" name="purchaseDate" value=
                                                <c:out value="${projectProducts.purchaseDate}"/> size="10"></td>
                                            <form action="desk/deleteProjectProduct/${projectProducts.id}" method="GET">
                                                <td class="text-center">
                                                    <input class="btn btn-info" type="submit" value="delete">
                                                </td>
                                            </form>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>