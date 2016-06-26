ymaps.ready(init);

        var myMap;
        
        function init() {
        myMap = new ymaps.Map("map", {
        center: [44.4, 34.1], // Углич
                zoom: 11
        }, {
        balloonMaxWidth: 200,
                searchControlProvider: 'yandex#search'
        });
                // Обработка события, возникающего при щелчке
                // левой кнопкой мыши в любой точке карты.
                // При возникновении такого события откроем балун.
                myMap.events.add('click', function (e) {
                if (!myMap.balloon.isOpen()) {                    
                var coords = e.get('coords');
                
                post_to_url("/confidential/desk/map/addPoint", {coordY: coords[0].toPrecision(6), coordX: coords[1].toPrecision(6)});
                
//                        myMap.balloon.open(coords, {
//                        contentHeader:'Событие!',
//                                contentBody:'<p>Кто-то щелкнул по карте.</p>' +
//                                '<p>Координаты щелчка: ' + [
//                                        coords[0].toPrecision(6),
//                                        coords[1].toPrecision(6)
//                                ].join(', ') + '</p>',
//                                contentFooter:'<sup>Щелкните еще раз</sup>'
//                        });
                }
                else {
                myMap.balloon.close();
                }
                });
                // Обработка события, возникающего при щелчке
                // правой кнопки мыши в любой точке карты.
                // При возникновении такого события покажем всплывающую подсказку
                // в точке щелчка.
                myMap.events.add('contextmenu', function (e) {
                myMap.hint.open(e.get('coords'), 'Кто-то щелкнул правой кнопкой');
                });
                // Скрываем хинт при открытии балуна.
                myMap.events.add('balloonopen', function (e) {
                myMap.hint.close();
                });
            }

function post_to_url(path, params, method) {
//        method = method || "post";
    method = method || "get";

    var form = document.createElement("form");

    form._submit_function_ = form.submit;

    form.setAttribute("method", method);
    form.setAttribute("action", path);

    for (var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);

        form.appendChild(hiddenField);
    }

    document.body.appendChild(form);
    form._submit_function_();
}
//    post_to_url("./postinfo.php", { submit: "submit" } );