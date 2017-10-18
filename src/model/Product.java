package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Product {
	private long idProduct;
	private String title;
	private String description;
	private double price;
	private long quantity;
	private String storageDate;
	// private long idCategory;
	private Category category;
	private long idUser;
	private String imageURL;

	public Product(long idProduct, String title, String description, double price, long quantity, String storageDate,
			Category category, long idUser, String imageURL) {
		this(title, description, price, quantity, category, idUser, imageURL);
		this.idProduct = idProduct;
		this.storageDate = storageDate;

	}

	public Product(String title, String description, double price, long quantity, Category category, long idUser,
			String imageURL) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		// this.idCategory = idCategory;
		this.category = category;
		this.idUser = idUser;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		this.storageDate = sdf.format(calendar.getTime());
		this.imageURL = imageURL;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public long getIdUser() {
		return idUser;
	}

	public String getStorageDate() {
		return storageDate;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public long getQuantity() {
		return quantity;
	}

	/*
	 * public long getIdCategory() { return idCategory; }
	 */

	public String toString() {
		return "Title:" + title + ", Description:" + description + ", Price:" + price + "$, Quantity:" + quantity
				+ ", Storage Date:" + storageDate;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
