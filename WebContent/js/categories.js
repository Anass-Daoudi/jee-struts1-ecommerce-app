function categories() {
	xhr = getxhr();
	xhr.open("GET", "ShopCategoriesAction.do", true);
	xhr.send("null");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("categories").innerHTML=xhr.responseText;
		}
		
	}
}
