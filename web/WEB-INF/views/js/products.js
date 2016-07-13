$(function () {
    $(".place").each(function () {
        var productId = this.id;
        $.get("/productsaleplace/get/" + productId, function (data) {
            console.log(productId);
            if (data > 0)
                $(".place#" + productId).html("+ " + data);
        });
    })
});

