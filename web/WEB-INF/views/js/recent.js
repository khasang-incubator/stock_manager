window.onload = function(){
	
}
function recentProduct(recentProducts){
	
	var recentDiv = document.getElementById("recent");
	
	for(var i = 0; i < recentProducts.length;i++){
		var newProduct = recentProducts[i];
		var div = document.createElement("div");
		div.setAttribute("class", "saleItem");
		div.innerHTML = i +" "+ newProduct.name +" "+ newProduct.numberOfItems;
		recentDiv.appendChild(div);
	}
}