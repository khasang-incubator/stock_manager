<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Projects</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../css/bootstrap-3.3.6-dist/css/bootstrap.min.css" type="text/css" media="all">
        <script src="../../css/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat:400,700|Cardo:400,400italic,700">

        <link rel="stylesheet" href="../../css/b&w/style.default.css" id="theme-stylesheet">
        <!-- ekko lightbox-->
        <link rel="stylesheet" href="../../css/b&w/ekko-lightbox.css">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="../../css/b&w/custom.css">
        <!-- Favicon-->
        <!--<link rel="shortcut icon" href="favicon.png">-->

        <script src="../../js/availableStateProject.js">
        </script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
        <!-- Bootstrap CDN-->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!-- jQuery Cookie - For Demo Purpose-->
        <script src="../../js/b&w/jquery.cookie.js"></script>
        <!-- Lightbox-->
        <script src="../../js/b&w/ekko-lightbox.js"></script>
        <!-- Sticky + Scroll To scripts for navbar-->
        <script src="../../js/b&w/jquery.sticky.js"></script>
        <script src="../../js/b&w/jquery.scrollTo.min.js"></script>
        <!-- main script-->
        <script src="../../js/b&w/front.js"></script>
    </head>
    <body>
        <header class="header">
            <div class="sticky-wrapper">
                <div role="navigation" class="navbar navbar-default">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-btn btn-sm navbar-toggle"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a href="/" class="navbar-brand scroll-to">StockManager</a>
                        </div>
                        <div id="navigation" class="collapse navbar-collapse navbar-right">
                            <ul class="nav navbar-nav">
                                <li><a href="/">Home</a></li>
                                <li><a href="/add_user">Registration</a></li>
                                <li><a href="/admin">Admin</a></li>
                                <li class="active"><a href="/desk">Desk</a></li>
                                <li><a href="/products">Goods</a></li>
                                <li><a href="#about">About</a></li>
                                <li><a href="#contact">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="heading">Projects</h4>
                    <!--ADD PROJECT BLOCK-->
                    <form action="desk/addProject" method="GET" role="form">
                        <legend>Add new project</legend>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="controls">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="projectName">Project name:</label>
                                                <input id="projectName" type="text" name="projectName" class="form-control" placeholder="project name">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="type">Type:</label>
                                                <input id="type" type="text" name="type" class="form-control" placeholder="project type">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="startDate">Start date:</label>
                                                <input id="startDate" type="date" name="startDate" class="form-control" placeholder="yyyy-mm-dd">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="finishDate">Finish date:</label>
                                                <input id="finishDate" type="date" name="finishDate" class="form-control" placeholder="yyyy-mm-dd">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-groupcontrol-group">
                                                <label for="totalAmount">Total amount:</label>
                                                <input id="totalAmount" type="text" name="totalAmount" class="form-control" placeholder="Total amount">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="vip">Vip:</label>
                                                <select class="form-control" name="vip" class="form-control" placeholder="Vip">
                                                    <option>No</option>
                                                    <option>Yes</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="userId">User id:</label>
                                                <select class="form-control" name="userId" class="form-control" placeholder="User id">
                                                    <option>select user id</option>
                                                    <c:forEach items="${users}" var="user">
                                                        <option><c:out value="${user.id}" /></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="state">State:</label>
                                                <select class="form-control" name="state" class="form-control" placeholder="State">
                                                    <option>process</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <input class="btn btn-primary btn-block" type="submit" value="add project" ></td>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <p>You will fill form for make new project.</p>
                                <p>All form fields is required.</p>
                                <p> text bla-bla-bla text bla-bla-bla text bla-bla-bla text bla-bla-bla
                                    text bla-bla-bla text bla-bla-bla text bla-bla-bla text bla-bla-bla
                                    text bla-bla-bla text bla-bla-bla text bla-bla-bla text bla-bla-bla
                                </p>
                            </div>
                        </div>
                </div>
            </div>

            <!--VIEW PROJECTS BLOCK-->
            <div class="col-md-12">
                <div class="table-responsive">
                    <c:if test="${fn:length(projects) > 0}">
                        <table id="viewProjectsTable" class="table table-striped table-hover table-bordered table-condensed">
                            <th  colspan = '11'><div class="text-center">Projects</div></th>
                            <tr>
                                <td class="text-center">id</td>
                                <td class="text-center">projectName</td>
                                <td class="text-center">type</td>
                                <td class="text-center">startDate</td>
                                <td class="text-center">finishDate</td>
                                <td class="text-center">totalAmount</td>
                                <td class="text-center">vip</td>
                                <td class="text-center">state</td>
                                <td class="text-center">userId</td>
                                <td class="text-center">update</td>
                                <td class="text-center">delete</td>
                            </tr>
                            <c:forEach items="${projects}" var="project">
                                <tr>
                                <form name="stateProjectForm" action="desk/updateStateProject" method="GET">
                                    <td class="text-center" ><input type="text" name="id" value=<c:out value="${project.id}" /> size="2" ></td>
                                    <td class="text-center"><input type="text" name="projectName" value=<c:out value="${project.projectName}" /> size="4" ></td>
                                    <td class="text-center"><input type="text" name="type" value=<c:out value="${project.type}" /> size="4" ></td>
                                    <td class="text-center"><input type="text" name="startDate" value=<c:out value="${project.startDate}" /> size="7" ></td>
                                    <td class="text-center"><input type="text" name="finishDate" value=<c:out value="${project.finishDate}" /> size="7" ></td>
                                    <td class="text-center"><input type="text" name="totalAmount" value=<c:out value="${project.totalAmount}" /> size="2" ></td>
                                    <td class="text-center"><input type="text" name="vip" value=<c:out value="${project.vip}" /> size="2" ></td>
                                    <td class="text-center">
                                        <select class="form-control" id="state" name="state">
                                            <option><c:out value="${project.state}" /></option>
                                        </select>
                                    </td>
                                    <td class="text-center"><input type="text" name="userId" value=<c:out value="${project.userId}" /> size="2" ></td>
                                    <td class="text-center">
                                        <input class="btn btn-info" type="submit" value="update" >
                                    </td>
                                </form>
                                <form action="desk/deleteProject/${project.id}" method="GET">
                                    <td class="text-center">
                                        <input class="btn btn-info" type="submit" value="delete" >
                                    </td>
                                </form>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>

            </div>
        </div>
        <!--PAGE FOOTER-->
        <div class="panel-footer">Panel footer</div>
    </body>
</html>