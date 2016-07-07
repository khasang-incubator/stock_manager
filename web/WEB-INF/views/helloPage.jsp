<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome to StackManager</title>
    <link href="css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Current User</h1>
<p>${username}</p>
<h1>Encrypt password</h1>
<p>${crypt}</p>

</body>
</html>
