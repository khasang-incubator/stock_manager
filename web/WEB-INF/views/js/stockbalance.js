function getMainTableStock() {
    // var url = "http://localhost:8080/js/category.json";
    // var request = new XMLHttpRequest();
    // request.open("GET", url);
    // request.onload = function () {
    //     if (request.status == 200) {
    //         fillColumnCategory(request.response)
    //     }
    // };
    // request.send(null);
}

function fillColumnCategory(responseText) {
    var columnCategory = document.getElementById("column_category");
    var categories = JSON.parse(responseText);
    for (var i = 0; i < categories.length; i++) {
        var category = categories[i];
        var div = document.createElement("div");
        if (i == 0) {
            div.setAttribute("class", "navigation__item navigation__item_state_selected");
            div.innerHTML = " <div class=\"category\"><div class=\"category__name\">" + category.name + "</div></div>";
        } else {
            div.setAttribute("class", "navigation__item");
            div.innerHTML = " <div class=\"category\"><a class=\"category__url\" href=\"\" onmousedown=\"\">" +
                "<div class=\"category__name\">" + category.name + "</div></a></div>";
        }
        columnCategory.appendChild(div);
    }
}
window.onload = getMainTableStock();
