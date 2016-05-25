<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TableCommands</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>
<button><a href="http://localhost:8080/romak_createTable">create</a></button>
<button><a href="http://localhost:8080/romak_truncate">delete all</a></button>
<button><a href="http://localhost:8080/romak_goodsSelect">select all</a></button>
<button><a href="http://localhost:8080/romak_tableUpdate">update</a></button>
<button><a href="http://localhost:8080/romak_deleteTable">delete table</a></button>
<button><a href="http://localhost:8080/romak_deleteTenRows">delete first ten rows</a></button>
</body>
</html>
