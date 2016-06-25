<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration result</title>
    <link href="../css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
    <meta http-equiv="refresh" content="3;/"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>git s
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">StockManager</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/add_user">Registration</a></li>
                <li><a href="/admin">Admin</a></li>
                <li><a href="/io.khasang.stockmanager.dao.desk">Desk</a></li>
                <li><a href="/products">Goods</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <h1>Registration result:</h1>
    <p>${result}</p>
</div>
</body>
</html>
