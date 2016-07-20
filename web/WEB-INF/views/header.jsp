<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li id="homeMenuItem"><a href="/">Home</a></li>
                <li id="addUserMenuItem"><a href="/add_user">Registration</a></li>
                <li id="adminMenuItem"><a href="/admin">Admin</a></li>
                <li id="descMenuItem"><a href="/desk">Desk</a></li>
                <li id="productsMenuItem"><a href="/products">Goods</a></li>
                <li id="pointMenuItem"><a href="/point">Map</a></li>
                <li id="aboutMenuItem"><a href="#about">About</a></li>
                <li id="contactMenuItem"><a href="#contact">Contact</a></li>
                <c:if test="${param.activeId} eq 'adminMenuItem'}">
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.authenticated}">
                            <li><a href="/admin/backup">Backup</a></li>
                            <li><a href="/admin/restore">Restore</a></li>
                        </c:when>
                    </c:choose>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:logoutSubmit()">Logout</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<script>
    function setActive() {
        var doc = document;
        var activeMenuItem = doc.getElementById("${param.activeId}");
        activeMenuItem.className = "active";
    }
    ;
    setActive();
</script>



