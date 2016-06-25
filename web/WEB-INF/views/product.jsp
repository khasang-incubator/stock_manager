<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="../css/starter-template.css">
<link rel="stylesheet" href="../css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<html>
<head>
    <title>Catalog products</title>
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
                <li class="active"><a href="/add_user">Registration</a></li>
                <li><a href="/admin">Admin</a></li>
                <li><a href="/io.khasang.stockmanager.dao.desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label for="focusedInput">Add new product</label></div>
            <div class="panel-body">
                <form:form method="post" action="add" commandName="product" class="form-inline">
                    <div class="form-group">
                            <td><label for="focusedInput">Product:</label>
                                <form:input path="name" class="form-control" id="focusedInput"/></td>
                            <td><label for="focusedInput">Description:</label>
                                <form:input path="description"  class="form-control"/></td>
                            <td valign="bottom"><input type="submit" value="Добавить"/></td>
                        </div>
                </form:form>
            </div>
        </div>
        <c:if test="${!empty productList}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Product</th>
                    <th>Description</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td><a href="delete/${product.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


    </div>
</div>

</body>
</html>
