<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="root">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Point Info</title>
    <script src="https://code.jquery.com/jquery-3.0.0.min.js"
            integrity="sha256-JmvOoLtYsmqlsWxa7mDSLMwa6dZ9rrIdtrrVYRnDRH0=" crossorigin="anonymous"></script>
    <script src="//api-maps.yandex.ru/2.0/?load=package.standard&lang=ru-RU" type="text/javascript"></script>
    <script src="js/angular.js" type="text/javascript"></script>
    <script src="js/angular-resource.js" type="text/javascript"></script>
    <%--<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>--%>
    <script src="js/root_point.js" type="text/javascript"></script>
    <link rel="icon" type="image/jpg" href="http://www.amuzzz.ru/uploads/posts/2012-10/13502811621168_13.jpeg"/>
    <link href="../css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <script src="js/logout.js"></script>
</head>
<body ng-controller="pointCtrl" data-ng-init="getLocation()">
<jsp:include page="header.jsp">
    <jsp:param name="activeId" value="pointMenuItem"/>
</jsp:include>
<div class="container">
    <div class="starter-template">
        <br/>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Название: Наша дача</label></div>
            <div class="panel-body">
                <div class="row">
                    <div id="map" style="min-width: 320px; min-height: 500px"></div>
                </div>
                <div class="row">
                    Адрес: г. Москва, ул. Шарикоподшипникова, д. 12
                </div>
                <div class="row">
                    <button ng-click="setLocation()">ADD SAVE</button>
                    <table ng-repeat="loc in locations">
                        <tr>
                            <td>{{loc.x}}</td>
                            <td>{{loc.y}}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>


</body>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>