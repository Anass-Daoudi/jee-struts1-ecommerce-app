package model;

public interface UserDAO {
	public abstract boolean insert(User user);

	public abstract boolean exists(String email);

	public abstract User exists(String email, String password);
}
