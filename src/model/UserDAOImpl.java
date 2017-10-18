package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	public boolean insert(User user) {
		ConnectionDB db = new ConnectionDB();
		String request = "insert into user (firstName,lastName,email,password,civility) values ('" + user.getFirstName()
				+ "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getPassword() + "','"
				+ user.getCivility() + "')";
		try {
			db.getStatement().executeUpdate(request);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			db.closeConnection();
		}
	}

	public boolean exists(String email) {
		ConnectionDB db = new ConnectionDB();
		String request = "select id from user where email='" + email + "'";

		try {
			ResultSet rs = db.getStatement().executeQuery(request);

			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		} finally {
			db.closeConnection();
		}
	}

	public User exists(String email, String password) {
		ConnectionDB db = new ConnectionDB();
		String request = "select * from user where email='" + email + "'and password='" + password + "'";

		try {
			ResultSet rs = db.getStatement().executeQuery(request);

			if (rs.next()) {
				return new User(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), email, password,
						rs.getString("civility"));
			}
			return null;
		} catch (SQLException e) {
			return null;
		} finally {
			db.closeConnection();
		}
	}
}
