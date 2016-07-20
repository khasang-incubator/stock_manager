<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product sale places</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="/css/starter-template.css">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- yandex map -->
    <script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="/js/mapproductsaleplace.js" type="text/javascript"></script>
    <script src="js/logout.js"></script>
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
<jsp:include page="header.jsp">
    <jsp:param name="activeId" value="productsMenuItem"/>
</jsp:include>
<div class="container">
    <div style="display:none">
        <form:form method="post" action="add" commandName="productSalePlace" class="form-inline" id="formPostPlace">
            <div class="form-group">
                <form:input path="id" class="form-control" id="idInvForm"/>
                <form:input path="description" class="form-control" id="descriptionInvForm"/>
                <form:input path="x" class="form-control" id="xInvForm"/>
                <form:input path="y" class="form-control" id="yInvForm"/>
                <input type="submit" value="Add" id="submitInvForm"/>
            </div>
        </form:form>
    </div>
    <div class="starter-template">
        <br>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Product:&nbsp;</label><label><h4>${productName}</h4></label>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-12" id="map">
                    </div>
                </div>
                <c:if test="${!empty productSalePlaceList}">
                    <c:forEach items="${productSalePlaceList}" var="productSalePlace">
                        <div class="row">
                            <div class="col-xs-12">
                                <a href="javascript:showPlace(${productSalePlace.x},${productSalePlace.y},'${productSalePlace.description}',${productSalePlace.id})"
                                   class="list-group-item place-content" id="#set-balloon">
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
    <footer class="footer">
        <div class="container">
            <hr/>
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <p style="text-align: center;">&copy; Stock-Manager</p>
            </div>
        </div>
    </footer>
</div>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
