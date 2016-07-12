$(function () {
    $(".circle").each(function () {
        var productId = this.id;
        $.get("/productsaleplace/get/" + productId, function (data) {
            console.log(productId);
            $(".circle#" + productId).html(data);
        });
    })
});

