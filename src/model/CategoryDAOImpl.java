package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAOImpl implements CategoryDAO {
	public ArrayList<Category> categories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		ConnectionDB db = new ConnectionDB();
		String request = "select * from category";

		try {
			ResultSet rs = db.getStatement().executeQuery(request);

			while (rs.next()) {
				categories.add(new Category(rs.getLong("idCategory"), rs.getString("category")));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return categories;
	}

	public Category category(long idCategory) {
		ConnectionDB db = new ConnectionDB();
		String request = "select * from category where idCategory=" + idCategory;

		try {
			ResultSet rs = db.getStatement().executeQuery(request);

			if (rs.next()) {
				return new Category(idCategory, rs.getString("category"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return null;
	}

}
