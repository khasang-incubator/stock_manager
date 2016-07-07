<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Catalog products</title>
    // bootstrap
    <link rel="stylesheet" href="../css/starter-template.css">
    <link rel="stylesheet" href="../css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
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
                <li><a href="/admin/backup">Backup</a></li>
                <li><a href="/admin/restore">Restore</a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label for="focusedInput">Add new product</label></div>
            <div class="panel-body">
                <form:form method="post" action="products/add" commandName="product" class="form-inline" >
                    <div class="form-group" >
                        <label for="focusedInput">Product:</label>
                            <form:input path="name" class="form-control" id="focusedInput"/>
                        <label for="focusedInput">Description:</label>
                            <form:input path="description" class="form-control"/>
                        <input type="submit" value="Добавить"/>
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
                        <td><a href="products/delete/${product.id}">Delete</a></td>
                        <td><a href="productsaleplace/${product.id}">Places</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


    </div>
</div>

</body>
</html>
