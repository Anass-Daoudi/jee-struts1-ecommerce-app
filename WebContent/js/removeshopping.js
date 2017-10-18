function removeProductShoppingCart(idProduct) {
	xhr = getxhr();
	xhr.open("POST", "ShoppingCartRemoveAction.do", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("idProduct=" + idProduct);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			location.href = "DisplayShoppingCartAction.do";
		}
	}
}