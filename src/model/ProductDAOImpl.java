package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
	public boolean insert(Product product) {
		ConnectionDB db = new ConnectionDB();
		String request = "insert into product (title,description,price,quantity,storageDate,idCategory,idUser,imageURL) values ('"
				+ product.getTitle() + "','" + product.getDescription() + "'," + product.getPrice() + ","
				+ product.getQuantity() + ",'"/* CURRENT_TIMESTAMP */ + product.getStorageDate() + "',"
				+ product.getCategory().getCategoryId() + "," + product.getIdUser() + ",'" + product.getImageURL()
				+ "')";
		try {
			db.getStatement().executeUpdate(request);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return false;
	}

	public ArrayList<Product> myProducts(long idUser) {
		ArrayList<Product> myProducts = new ArrayList<Product>();
		ConnectionDB db = new ConnectionDB();
		String request = "select * from product where idUser=" + idUser;

		try {
			ResultSet rs = db.getStatement().executeQuery(request);
			CategoryDAOImpl u = new CategoryDAOImpl();
			long idCategory;

			while (rs.next()) {
				idCategory = rs.getLong("idCategory");

				myProducts.add(new Product(rs.getLong("idProduct"), rs.getString("title"), rs.getString("description"),
						rs.getDouble("price"), rs.getLong("quantity"), rs.getString("storageDate"),
						u.category(idCategory), rs.getLong("idUser"), rs.getString("imageURL")));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return myProducts;
	}

	public ArrayList<Product> allProducts() {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		ConnectionDB db = new ConnectionDB();
		String request = "select * from product";

		try {
			ResultSet rs = db.getStatement().executeQuery(request);
			CategoryDAOImpl u = new CategoryDAOImpl();
			long idCategory;

			while (rs.next()) {
				idCategory = rs.getLong("idCategory");
				allProducts.add(new Product(rs.getLong("idProduct"), rs.getString("title"), rs.getString("description"),
						rs.getDouble("price"), rs.getLong("quantity"), rs.getString("storageDate"),
						u.category(idCategory), rs.getLong("idUser"), rs.getString("imageURL")));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return allProducts;
	}

	public ArrayList<Product> allProduct(long idCategory) {
		ArrayList<Product> products = new ArrayList<Product>();
		ConnectionDB db = new ConnectionDB();
		CategoryDAOImpl u = new CategoryDAOImpl();

		String request = "select * from product where idCategory=" + idCategory;

		try {
			ResultSet rs = db.getStatement().executeQuery(request);

			while (rs.next()) {
				products.add(new Product(rs.getLong("idProduct"), rs.getString("title"), rs.getString("description"),
						rs.getDouble("price"), rs.getLong("quantity"), rs.getString("storageDate"),
						u.category(idCategory), rs.getLong("idUser"), rs.getString("imageURL")));
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return null;
	}

	public void removeProduct(long idProduct) {
		ConnectionDB db = new ConnectionDB();
		String sql = "delete from product where idProduct=" + idProduct;
		try {
			db.getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
	}

	public Product getProduct(long idProduct) {
		ConnectionDB db = new ConnectionDB();
		CategoryDAOImpl u = new CategoryDAOImpl();
		String sql = "select * from product where idProduct=" + idProduct;
		try {
			ResultSet rs = db.getStatement().executeQuery(sql);
			if (rs.next()) {
				long idCategory = rs.getLong("idCategory");
				return new Product(rs.getLong("idProduct"), rs.getString("title"), rs.getString("description"),
						rs.getDouble("price"), rs.getLong("quantity"), rs.getString("storageDate"),
						u.category(idCategory), rs.getLong("idUser"), rs.getString("imageURL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return null;
	}

}
