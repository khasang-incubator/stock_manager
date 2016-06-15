/* global ymaps */

var LOCATION = {
    x: 0,
    y: 0
};

angular.module("root", ["ngResource"]).controller("point", ["$scope", "$resource", function ($scope, $resource) {
    var locationGET = $resource("/service/location", {get: {method: 'GET'}});
    var locationPOST = $resource("/service/location", {post: {method: 'POST'}});
    var locationDELETE = $resource("/service/location", {delete: {method: 'DELETE'}});

    $scope.getLocation = function () {
        $scope.location = locationGET.get(function (data) {
            LOCATION.x = data.x;
            LOCATION.y = data.y;
        });
    };

    $scope.setLocation = function () {
        $scope.location = locationPOST.save({x: LOCATION.x, y: LOCATION.y}, function (data) {
            alert(data);
            dataO = data;
        });
    };

    $scope.deleteLocation = function () {
        var response = $scope.locationDELETE.remove(function (data) {
            alert(data);
        });
    };
}]);

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
    myMap.events.add('click', function (e) {
        if (!myMap.balloon.isOpen()) {
            coords = e.get('coordPosition');
            myMap.balloon.open(coords, {
                contentHeader:'Событие!',
                contentBody:'<p>Кто-то щелкнул по карте.</p>' +
                '<p>Координаты щелчка: ' + [
                    coords[0].toPrecision(6),
                    coords[1].toPrecision(6)
                ].join(', ') + '</p>',
                contentFooter:'<sup>Щелкните еще раз</sup>'
            });
        }
        else {
            myMap.balloon.close();
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