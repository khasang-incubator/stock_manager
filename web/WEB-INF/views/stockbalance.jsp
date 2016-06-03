<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Manager</title>
    <link rel="stylesheet" href="../css/stockbalance.css">
    <script src="../js/stockbalance.js"></script>
</head>
<!--header-->
<div class="header__main">
    <div class="header__column_category gridHeaderCell">Категория</div>
    <div class="header__column_product gridHeaderCell">Товар</div>
</div>
<!--rows-->
<div class="main" id = "main_table_stock">
    <div class="main__left" style="left: 0px;">
        <div class="navigation__region" id="column_category">
            ${column_category}
        </div>
    </div>
    <div class="main__center">
        <div class="product-list">
            <div class="product-item">
                <h2 class="product-item__title">
                    <a class="link link_cropped_no product-item__title-link" href="">Вентилятор BINATONE ALPINE 160вт,
                        напольный, оконный</a>
                </h2>
                <div class="product-item__text">
                    <span class="product__text">
                        Нормальный вентилятор, можно использовать. В-789. Реквизиты. Товар / Товар / Вентилятор BINATONE ALPINE 160вт, напольный , оконный. Базовая единица.
                    </span>
                </div>
                <div class="product-item__stock">
                    <span class="product-item__stock_text">
                        На складе - 2 шт.
                    </span>
                </div>
            </div>
            <div class="product-item">
                <h2 class="product-item__title">
                    <a class="product-item__title-link" href="">Кондиционер ELEKTA</a>
                </h2>
                <div class="product-item__text">
                    <span class="product__text">
                        Канальные кондиционеры Electra серии EMD позволяют кондиционировать одновременно несколько
                        помещений с помощью подключенной к внутреннему агрегату системы воздуховодов, установленных
                        над подвесным потолком. Электронный и инфракрасные блоки дистанционного управления взаимодействуют
                        с приемником (расположенным на расстоянии до 10 м. от внутреннего блока). В качестве дополнительной
                        опции на каждый нагревательный воздуховод может быть установлен ионизатор воздуха.
                    </span>
                </div>
                <div class="product-item__stock">
                    <span class="product-item__stock_text">
                        На складе - 5 шт.
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
