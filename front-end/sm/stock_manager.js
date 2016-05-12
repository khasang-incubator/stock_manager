
window.onload = function () {
    var url = "http://localhost:8080/sm/items.json";
    var request = new XMLHttpRequest();
    request.open("GET", url);
    request.onload = function () {
        if (request.status == 200) {
            updateTable(request.responseText);
        }
    };
    request.send(null);
}


function updateTable(responseText) {
    var itemsTable = document.getElementById("table_with_items");
    var items = JSON.parse(responseText);

    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        var tr = document.createElement("tr");
        addNewThToTr(tr, item.id);
        addNewThToTr(tr, item.name);
        addNewThToTr(tr, item.size);
        addNewThToTr(tr, item.unit);
        addNewThToTr(tr, item.quantity);
        addNewThToTr(tr, item.cost);
        itemsTable.appendChild(tr);
    }
}

function addNewThToTr(tr, type) {
    var th = document.createElement("th");
    th.setAttribute("class", "id_of_item");
    th.innerHTML = type;
    tr.appendChild(th);
}

// window.onload = function () {
//    var url = "http://localhost:8080/gumball/sales.json";
//     var url = "http://gumball.wickedlysmart.com/";
//     var url = "http://gumball.wickedlysmart.com/gumball/gumball.html";
//     var request = new XMLHttpRequest();
//     request.open("GET", url);
//     request.onload = function () {
//         if (request.status == 200) {
//             updateSales(request.responseText);
//         }
//     };
//     request.send(null);
//     setInterval(handleRefresh, 3000);
// }

// function handleRefresh() {
//     var url = "http://gumball.wickedlysmart.com" +
//         "?callback=updateSales" +
//         "&lastreporttime=" + lastReportTime +
//         "&random=" + (new Date()).getTime();
//     var newScriptElement = document.createElement("script");
//     newScriptElement.setAttribute("src", url);
//     newScriptElement.setAttribute("id", "jsonp");
//
//     var oldScriptElement = document.getElementById("jsonp");
//     var head = document.getElementsByTagName("head")[0];
//     if (oldScriptElement == null) {
//         head.appendChild(newScriptElement);
//     } else {
//         head.replaceChild(newScriptElement, oldScriptElement);
//     }
// }

// function updateSales(sales) {
//     var salesDiv = document.getElementById("sales");
//     // var sales = JSON.parse(responseText);
//     for (var i = 0; i < sales.length; i++) {
//         var sale = sales[i];
//         var div = document.createElement("div");
//         div.setAttribute("class", "saleItem");
//         div.innerHTML = sale.name + " sold " + sale.sales + " gumballs";
//         salesDiv.appendChild(div);
//     }
//     if (sales.length > 0) {
//         lastReportTime = sales[sales.length-1].time;
//     }
// }
