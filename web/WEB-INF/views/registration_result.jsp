<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration result</title>
    <link href="../css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <meta http-equiv="refresh" content="3;/"/>
    <script src="js/logout.js"></script>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="activeId" value="addUserMenuItem"/>
</jsp:include>
<div class="container">
    <div class="starter-template">
        <br>
        <div class="panel panel-default">
            <div class="panel-heading" align="left"><label>Registration result</label></div>
            <div class="panel-body">
                <div class="row">
                    <p>${result}</p>
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
