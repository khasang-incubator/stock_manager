<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Point Info</title>
    <link rel="icon" type="image/jpg" href="http://beautypic.ru/uploads/posts/2011-06/1308244405_beautipic-414.jpg" />
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <link href="css/site.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script type="text/javascript">
        ymaps.ready(init);
        var myMap,
                myPlacemark;
        function init(){
            myMap = new ymaps.Map("map", {
                center: [${coordY}, ${coordX}],
                zoom: 7
            });

            myPlacemark = new ymaps.Placemark([${coordY}, ${coordX}], {
                hintContent: 'Москва!',
                balloonContent: 'Столица России'
            });

            myMap.geoObjects.add(myPlacemark);
        }
    </script>
</head>
<body>
<div id="header" class="col-lg-12">
    <div class="col-lg-4">
        <button type="button" class="btn btn-link">Назад</button>
    </div>
    <div class="col-lg-4">
    </div>
    <div class="col-lg-4"></div>
</div>
<div id="container" class="col-lg-12">
    <div class="col-lg-2">
    </div>
    <div id="map" class="col-lg-4" style="min-width: 320px; min-height: 240px"></div>
    <div class="col-lg-4">
        <div class="col-lg-12 block panel-body">
            <h2>Название: Наша дача</h2>
        </div>
        <div class="col-lg-12 block panel-body">
            <span><h4>Адрес: г. Москва, ул. Шарикоподшипникова, д. 12</h4></span>
        </div>
    </div>
    <div class="col-lg-2"></div>
</div>
<div id="footer" class="col-lg-12">
    <hr />
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <p style="text-align: center;">&copy; 2016 - Stock Manager Team</p>
    </div>
    <div class="col-lg-4"></div>
</div>
</body>
</html>