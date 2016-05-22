<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Employees Info</title>
    <script src="/js/employees_info.js"></script>
    <link rel="stylesheet" href="/css/employees_info.css">
</head>
<body>
<h1>Employees Info</h1>
<br/>

<!--p>raw data: ${allEmployeeInfo}</p-->
<div id="result"></div>
<script>updateResults('${allEmployeeInfo}');</script>
</body>
</html>
