
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bodyStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/headerStyle.css"/>
    <script src="js/recent.js"></script>
</head>
<body>
<header class="container">
    <div class="row">
        <h1 class="col-sm-4">Stock Manager</h1>
        <nav class="col-sm-8 text-right">
            <p><a href="/romak_NewProducts">recent</a></p>
            <p>available</p>
            <p>to sent</p>
</header>
<div class="col-sm-8" id="recent" style="font-size:150%;color:rgb(256,256,256)">
</div>
<script src="webService/?callback=recentProduct"></script>
</body>
</html>
