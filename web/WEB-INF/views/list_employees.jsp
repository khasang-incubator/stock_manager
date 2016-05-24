<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of company's employees</title>
    <title>Company Employees Info</title>
    <script src="/js/list_employees.js"></script>
    <link rel="stylesheet" href="/css/list_employees.css">
</head>
<body>
<h1>All employees of company</h1>
<a href="/">home</a>
<p id="help_label">Result:</p>
<div id="result"/>
<script>updateResults('${employeeList}');</script>
</body>
</html>
