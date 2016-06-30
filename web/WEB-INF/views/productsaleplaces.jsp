<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product sale places</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="/css/starter-template.css">
    <link rel="stylesheet" href="/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
    <!-- yandex map -->
    <script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="/js/mapproductsaleplace.js" type="text/javascript"></script>
    <style>
        #map {
            width: 100%;
            height: 300px;
        }

        .place-content {
            font-size: 14px;
            margin-top: 10px;
            margin-bottom: 10px;
            padding: 0px 0px;
        }
    </style>
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
                <li class="active"><a href="/admin">Admin</a></li>
                <li><a href="/desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
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
    <div style="display:none">
        <form:form method="post" action="add" commandName="productSalePlace" class="form-inline" id="formPostPlace">
            <div class="form-group">
                <form:input path="description" class="form-control" id="descriptionInvForm"/>
                <form:input path="x" class="form-control" id="xInvForm"/>
                <form:input path="y" class="form-control" id="yInvForm"/>
                <input type="submit" value="Add" id="submitInvForm"/>
            </div>
        </form:form>
    </div>
    <div class="starter-template">
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>sale places</label></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-12" id="map">
                    </div>
                </div>
                <c:if test="${!empty productSalePlaceList}">
                    <c:forEach items="${productSalePlaceList}" var="productSalePlace">
                        <div class="row">
                            <div class="col-xs-12">
                                <a href="javascript:showPlace(${productSalePlace.x},${productSalePlace.y},'${productSalePlace.description}',${productSalePlace.id})" class="list-group-item place-content" id="#set-balloon">
                                    <div class="place-content bg-alt">
                                        <dl class="dl-horizontal">
                                            <dt>Place:</dt>
                                            <dd>${productSalePlace.description}</dd>
                                            <dt>Coordinates:</dt>
                                            <dd><span class="badge">${productSalePlace.x}</span> <span
                                                    class="badge">${productSalePlace.y}</span></dd>
                                        </dl>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>
