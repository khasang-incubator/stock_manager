function getTranslated(response) {
    if (response.code = 200) {
        var wordToTranslate = document.getElementById('wordToTranslate').value;
        var tr = document.createElement("tr");
        var engWord = document.createElement("td");
        var ruWord = document.createElement("td");
        engWord.innerText = wordToTranslate;
        ruWord.innerText = response.text;
        tr.appendChild(engWord);
        tr.appendChild(ruWord);
        document.getElementById('resultTable').appendChild(tr);
    }
}

function getJsonpTranslate() {
    var wordToTranslate = document.getElementById('wordToTranslate').value;
    var url = createUrl(wordToTranslate);
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

function createUrl(text) {
    var key = 'trnsl.1.1.20160514T122535Z.67b6219bac63f385.f4c1cc866bdf1bf605c2f862a17b18d74a64825a';
    return "https://translate.yandex.net/api/v1.5/tr.json/translate?callback=getTranslated&lang=en-ru&key=" + key + '&text=' + text
}