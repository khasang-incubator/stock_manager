<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Employees Info</title>
    <script src="/js/employees_info.js"></script>
    <link rel="stylesheet" href="/css/employees_info.css">
</head>
<body>
<h1>Employees Info</h1>
<a href="/">home</a>
<!--p>raw data: ${allEmployeeInfo}</p-->
<p id="help_label">Result:</p>
<div id="result"/>
<script>updateResults('${allEmployeeInfo}');</script>
</body>
</html>
