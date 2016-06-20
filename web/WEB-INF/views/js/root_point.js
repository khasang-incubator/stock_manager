/* global ymaps */

var locations;
var placemarks = [];

var angularSaveLocation;

angular.module("root", []).controller("pointCtrl", function ($scope, $http, $compile) {
    $scope.getLocation = function () {
        // $http.get - выполняем HTTP GET запрос к указанному ресурсу.
        $http.get("service/location").success(function (response) {
            // при успешной обработке запроса передаем данные в scope\
            $scope.locations = response;

        })
    };

    $scope.setLocation = function () {
        var locations = [];
        for(var location in $scope.locations) {
            locations.push({x:$scope.locations[location].x, y:$scope.locations[location].y});
        }
        
        $http.put("service/location", locations).success(function (response) {
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

    $scope.saveLocation = function (x, y) {
        $scope.locations.push({x: x, y: y});
    };
    
    $scope.addClickFunc = function (id, coords) {
        var element = '<button ng-click="saveLocation(' + coords[0] + ',' + coords[1] + ')">Save</button>';
        document.getElementById(id).innerHTML = element;
        $compile(document.getElementById(id))($scope);
    }
    
    ymaps.ready(init);
    var myMap, myPlacemark, coords;

    function init() {
        myMap = new ymaps.Map("map", {
            center: [0, 0],
            zoom: 7
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
                    '<span id="ballon' + coords[0] + '"></span>',
                    contentFooter: '<sup>Щелкните еще раз</sup>'
                });
                $scope.addClickFunc('ballon' + coords[0], coords);
            }
            else {
                myMap.balloon.close();
                var placemark = new ymaps.Placemark([coords[0], coords[1]]);
                myMap.geoObjects.add(placemark);
            }
        });
        myMap.geoObjects.add(myPlacemark);
        $scope.locations.forEach(addToPlacemarkArray);
    }
});

function addToPlacemarkArray(location) {
    var placemark = new ymaps.Placemark([location.x, location.y]);
    myMap.geoObjects.add(placemark);
}