/* global ymaps */

var LOCATION = {
    x: 0,
    y: 0
};

angular.module("root", ["ngResource"]).controller("point", ["$scope", "$resource", function ($scope, $resource) {
        var location = $resource("/service/location");
        console.log(location);

        $scope.getLocation = function () {
            $scope.location = location.get(function (data) {
                LOCATION.x = data.x;
                LOCATION.y = data.y;
            });
        };

        $scope.postUser = function () {
            var response = $scope.user.$save(function () {
                alert("User saved!");
            });
        };
    }]);

ymaps.ready(init);
var myMap, myPlacemark;
function init() {
    myMap = new ymaps.Map("map", {
        center: [LOCATION.x, LOCATION.y],
        zoom: 7
    });
    myPlacemark = new ymaps.Placemark([2, 2], {
        hintContent: 'Москва!',
        balloonContent: 'Столица России'
    });
    myMap.geoObjects.add(myPlacemark);
}