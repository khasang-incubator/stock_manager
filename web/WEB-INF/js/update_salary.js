function updateResults(data) {
    var resultsDiv = document.getElementById("result");
    var table = document.createElement("table");
    table.setAttribute("class", "salaries_table");
    var trheader = document.createElement("tr");
    trheader.setAttribute("class", "theader");
    var tdheader0 = document.createElement("td");
    tdheader0.innerHTML = 'id';
    trheader.appendChild(tdheader0);
    trheader.setAttribute("class", "theader");
    var tdheader1 = document.createElement("td");
    tdheader1.innerHTML = 'First name';
    trheader.appendChild(tdheader1);
    var tdheader2 = document.createElement("td");
    tdheader2.innerHTML = 'Last name';
    trheader.appendChild(tdheader2);
    var tdheader3 = document.createElement("td");
    tdheader3.innerHTML = 'Position';
    trheader.appendChild(tdheader3);
    var tdheader4 = document.createElement("td");
    tdheader4.innerHTML = 'Phone';
    trheader.appendChild(tdheader4);
    var tdheader5 = document.createElement("td");
    tdheader5.innerHTML = 'Email';
    trheader.appendChild(tdheader5);
    var tdheader6 = document.createElement("td");
    tdheader6.innerHTML = 'Salary';
    trheader.appendChild(tdheader6);
    var tdheader7 = document.createElement("td");
    tdheader7.innerHTML = 'Currency';
    trheader.appendChild(tdheader7);
    table.appendChild(trheader);
    var dataJson = JSON.parse(data);
    for (var i = 0; i < dataJson.length; i++) {
        var obj = dataJson[i];
        var tr = document.createElement("tr");
        for (var key in obj) {
            var td = document.createElement("td")
            td.innerHTML = obj[key];
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    resultsDiv.appendChild(table);
}