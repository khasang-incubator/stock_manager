window.onload = welcome;

function welcome() {
    var welcomeElement = document.getElementById('welcomeText');
    welcomeElement.innerHTML = "Введите параметры таблицы.";
}


function textForTable() {
    var welcomeElement = document.getElementById('welcomeText');
    welcomeElement.innerHTML = "Таблица, сгенерированная в JS.";
}
function createTable() {
    var source = "";
    source += "<table width = '100%'>";
    source += "<tr>";
    return source;
}

function fillTable(cols, rows) {
    if (cols < 1) {
        cols = 0;
    }
    if (rows < 1) {
        rows = 0;
    }
    textForTable();
    var source = "<hr width = '100%'>";
    source += createTable();
    for (row = 0; row < rows; row++) {
        for (col = 0; col < cols; col++) {
            source += "<td align = 'center'>";
            source += " столбец:" + (col + 1) + " / строка:" + (row + 1);
            source += "</td>";
        }
        source += "</tr><tr>";
    }
    source += closeTable();
    print(source);
}

function print(source) {
    var page = document.getElementById("table");
    page.innerHTML = source;
}
function closeTable() {
    return "</table>";
}