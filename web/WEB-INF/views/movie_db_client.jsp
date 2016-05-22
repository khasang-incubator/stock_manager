<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Open Movie Database Client</title>
    <script src="/js/movie_db_client.js"></script>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/movie_db_client.css">
</head>
<body>
<div class="main_body_class">
    <h1>The Open Movie Database API client</h1>
    <a href="/">home</a>
    <p id="help_label">Enter film name you want to find:</p>
    <form>
        <input type="text" id="movieTextInput" size="40" placeholder="Movie name" onkeypress="return handleTextInput(event)">
        <input type="button" id="searchButton" value="Search Movie">
    </form>
    <br/>
    <div id="result"></div>
</div>
</body>
