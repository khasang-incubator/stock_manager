/* global ymaps */

var LOCATION = {
    x: 0,
    y: 0
};

var angularSaveLocation;

angular.module("root", []).controller("pointCtrl", function ($scope, $http) {
    $scope.getLocation = function () {
        // $http.get - выполняем HTTP GET запрос к указанному ресурсу.
        $http.get("service/location").success(function (response) {
            // при успешной обработке запроса передаем данные в scope
            LOCATION.x = response.x;
            LOCATION.y = response.y;
        })
    };


    $scope.setLocation = function () {
        $http.post("service/location", $scope.locations).success(function (response) {
            alert("success" + response)
        }).error(function (response) {
            alert(response)
        })
    };

    $scope.deleteLocation = function () {
        var response = $scope.locationDELETE.remove(function (data) {
            alert(data);
        });
    };

    $scope.locations = [];

    angularSaveLocation = $scope.saveLocation = function (x, y) {
        $scope.locations.push({x: x, y: y});
        $scope.$apply();
    };
});

ymaps.ready(init);
var myMap, myPlacemark, coords;
function init() {
    myMap = new ymaps.Map("map", {
        center: [LOCATION.x, LOCATION.y],
        zoom: 7
    });
    myPlacemark = new ymaps.Placemark([2, 2], {
        hintContent: '!!!!!!!!',
        balloonContent: '???????????/'
    });
    myMap.events.add('click', function (event) {
        if (!myMap.balloon.isOpen()) {
            coords = event.get('coordPosition');
            myMap.balloon.open(coords, {
                contentHeader: 'Событие!',
                contentBody: '<p>Кто-то щелкнул по карте.</p>' +
                '<p>Координаты щелчка: ' + [
                    coords[0].toPrecision(6),
                    coords[1].toPrecision(6)
                ].join(', ') + '</p>' +
                '<button onclick="angularSaveLocation(' + coords[0] + ',' + coords[1] + ')">Save</button>',
                contentFooter: '<sup>Щелкните еще раз</sup>'
            });
        }
        else {
            myMap.balloon.close();
            var placemark = new ymaps.Placemark([coords[0], coords[1]]);
            myMap.geoObjects.add(placemark);
        }
        LOCATION.x = coords[0].toPrecision(6);
        LOCATION.y = coords[1].toPrecision(6);
    });
    myMap.geoObjects.add(myPlacemark);
}

// ymaps.ready(init);
// var myMap, myPlacemark, act;
//
// function init () {
//     myMap = new ymaps.Map("map", {
//         center: [57.5262, 38.3061], // Углич
//         zoom: 11
//     }, {
//         balloonMaxWidth: 200
//     });
//
//     // Обработка события, возникающего при щелчке
//     // левой кнопкой мыши в любой точке карты.
//     // При возникновении такого события откроем балун.
//     myMap.events.add('click', function (e) {
//         if (!myMap.balloon.isOpen()) {
//             var coords = e.get('coordPosition');
//             myMap.balloon.open(coords, {
//                 contentHeader:'Событие!',
//                 contentBody:'<p>Кто-то щелкнул по карте.</p>' +
//                 '<p>Координаты щелчка: ' + [
//                     coords[0].toPrecision(6),
//                     coords[1].toPrecision(6)
//                 ].join(', ') + '</p>',
//                 contentFooter:'<sup>Щелкните еще раз</sup>'
//             });
//         }
//         else {
//             myMap.balloon.close();
//         }
//     });
//
//     // Обработка события, возникающего при щелчке
//     // правой кнопки мыши в любой точке карты.
//     // При возникновении такого события покажем всплывающую подсказку
//     // в точке щелчка.
//     myMap.events.add('contextmenu', function (e) {
//         myMap.hint.show(e.get('coordPosition'), 'Кто-то щелкнул правой кнопкой');
//     });
// }