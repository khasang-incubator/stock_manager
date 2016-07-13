<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Catalog products</title>
    <link rel="stylesheet" href="../css/starter-template.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <script src="js/logout.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/products.js"></script>

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
                <li><a href="/admin">Admin</a></li>
                <li><a href="/add_user">Registration</a></li>
                <li><a href="/desk">Desk</a></li>
                <li class="active"><a href="/products">Goods</a></li>
                <li><a href="/point">Map</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <br>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label for="focusedInput">Catalog products</label></div>
            <div class="panel-body">
                <div class="row">
                    <form:form method="post" action="products/add" commandName="product" class="form-inline">
                        <label for="focusedInput">Add new product:</label>
                        <form:input path="name" class="form-control" id="focusedInput"/>
                        <label for="focusedInput">Description:</label>
                        <form:input path="description" class="form-control"/>
                        <input type="submit" value="Add"/>
                    </form:form>
                </div>
                <div class="row">
                    <c:if test="${!empty productList}">
                        <c:set var="count" scope="page" value="0"/>
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>№</th>
                                <th>Product</th>
                                <th>Description</th>
                                <th>Sale place</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productList}" var="product">
                                <c:set var="count" scope="page" value="${count + 1}"/>
                                <tr>
                                    <td>${count}</td>
                                    <td>${product.name}</td>
                                    <td>${product.description}</td>
                                    <td><a href="productsaleplace/${product.id}">
                                        <p style="float: left; margin-right:5px;"><img src="img/place.png" width="20"
                                                                                       height="30"></p>
                                        <div class="place" id="${product.id}"></div>
                                    </a></td>
                                    <td><a href="products/delete/${product.id}">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
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
