function shoppingCart(idProduct) {
	xhr = getxhr();
	xhr.open("POST", "ShoppingCartAction.do", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("idProduct=" + idProduct);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("shoppingCart").innerHTML = "Cart: "
					+ xhr.responseText + " products";
		}
	}
}
