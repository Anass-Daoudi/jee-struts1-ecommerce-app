function products(id) {
	xhr = getxhr();
	xhr.open("POST", "ShopProductAction.do", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("idCategory=" + document.getElementById("categoryChoice").value);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("products").innerHTML = xhr.responseText;
		}
	}
}