package model;

import java.util.ArrayList;

public class User {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String civility;
	private ArrayList<Product> myProducts;

	public User(long id, String firstName, String lastName, String email, String password, String civility) {
		this(firstName, lastName, email, password, civility);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public User(String firstName, String lastName, String email, String password, String civility) {
		this(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.civility = civility;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public void setMyProducts(ArrayList<Product> myProducts) {
		this.myProducts = new ArrayList<Product>(myProducts);
	}

	public void addNewProduct(Product product) {
		myProducts.add(product);
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public ArrayList<Product> getMyProducts() {
		return myProducts;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCivility() {
		return civility;
	}

}
