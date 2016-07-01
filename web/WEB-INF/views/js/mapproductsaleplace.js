var myMap;
var coords;
ymaps.ready(init);

function init() {
    myMap = new ymaps.Map('map', {
        // При инициализации карты обязательно нужно указать
        // её центр и коэффициент масштабирования.
        center: [55.76, 37.64], // Москва
        zoom: 10
    }, {
        balloonMaxWidth: 320,
        searchControlProvider: 'yandex#search'
    });

    addPlaceClickFunc = function () {
        document.getElementById('descriptionInvForm').value = document.getElementById('descriptionBalloon').value;
        document.getElementById('xInvForm').value = coords[0].toPrecision(6);
        document.getElementById('yInvForm').value = coords[1].toPrecision(6);
        document.getElementById('submitInvForm').click();
    }

    myMap.events.add('click', function (e) {
        coords = e.get('coords');
        myMap.balloon.open(coords, {
            contentHeader: 'Place:',
            contentBody: '<input type="text" size="40"  id="descriptionBalloon">' +
            '<p>Coordinates: ' + [
                coords[0].toPrecision(6),
                coords[1].toPrecision(6)
            ].join(', ') + '</p>' +
            '<span id="balloon' + coords[0] + '"><button onclick="addPlaceClickFunc()">Save</button></span>'
        });

    });

    showPlace = function (x,y,place,id) {
        apostrof = "'";
        var coords = [x, y];
        myMap.balloon.open(coords, {
            contentHeader: 'Place:',
            contentBody: place +
            '<p>Coordinates: ' + [
                coords[0].toPrecision(6),
                coords[1].toPrecision(6)
            ].join(', ') + '</p>' +
            '<span id="balloon' + coords[0] + '"><button onclick="location.href=' + apostrof + 'delete/' +
             + id + apostrof+ '">Delete</button></span>'
        });
    };
}

