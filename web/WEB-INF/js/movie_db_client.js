/* quntum.js */
/*
 * find movies in The Open Movie Database
 *
 */
window.onload = init;

function init() {
    var button = document.getElementById("searchButton");
    button.onclick = handleSearchButtonClick;
    var textInput = document.getElementById("movieTextInput");
}

function handleTextInput(e) {
    if (e.keyCode == 13) {
        handleSearch();
        return false;
    }
}

function handleSearchButtonClick() {
    handleSearch();
}

function handleSearch() {
    var textInput = document.getElementById("movieTextInput");
    var movieName = textInput.value;
    if (movieName == "") {
        alert("Please enter a movie");
    } else {
        searchMovie(movieName);
    }
}

function searchMovie(movieName) {
    var url = "http://www.omdbapi.com?callback=updateResults&t=" + movieName;
    var newScriptElement = document.createElement("script");
    newScriptElement.setAttribute("src", url);
    newScriptElement.setAttribute("id", "jsonp");
    var oldScriptElement = document.getElementById("jsonp");
    var head = document.getElementsByTagName("head")[0];
    if (oldScriptElement == null) {
        head.appendChild(newScriptElement);
    }
    else {
        head.replaceChild(newScriptElement, oldScriptElement);
    }
}

// called with jsonp (callback)
function updateResults(result) {
    var resultsDiv = document.getElementById("result");
    while (resultsDiv.firstChild) {
        resultsDiv.removeChild(resultsDiv.firstChild);
    }
    var div = document.createElement("div");
    if (result.Response == "False") {
        div.innerHTML = result.Error;
    } else {
        var table = document.createElement("table");
        var th = document.createElement("tr");
        var td = document.createElement("td");
        td.setAttribute("colspan", "2");
        td.innerHTML = "Result of search";
        //var tdempty = document.createElement("td");
        th.setAttribute("class", "theader");
        th.appendChild(td);
       // th.appendChild(tdempty);
        table.appendChild(th);
        for (var prop in result) {
            console.log(prop);
            //Do your logic with the property here
            var tr = document.createElement("tr");
            var td1 = document.createElement("td")
            td1.innerHTML = prop;
            var td2 = document.createElement("td");
            td2.innerHTML = result[prop];
            tr.appendChild(td1);
            tr.appendChild(td2);
            table.appendChild(tr);
        }
        div.appendChild(table);
    }
    resultsDiv.appendChild(div);
}


