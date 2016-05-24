<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees Salaries</title>
    <script src="/js/update_salary.js"></script>
    <link rel="stylesheet" href="/css/update_salary.css">
</head>
<body>
<h1>Employees salaries</h1>
<a href="/">home</a>
<div id="result"/>
<script>updateResults('${employeeSalariesList}');</script>
</body>
</html>
