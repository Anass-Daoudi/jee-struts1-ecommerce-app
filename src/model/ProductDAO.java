package model;

import java.util.ArrayList;

public interface ProductDAO {
	public abstract boolean insert(Product product);

	public abstract ArrayList<Product> myProducts(long idUser);

	public abstract ArrayList<Product> allProducts();

	public abstract void removeProduct(long idProduct);

	public abstract Product getProduct(long idProduct);
}
