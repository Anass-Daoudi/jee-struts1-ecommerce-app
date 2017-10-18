package model;

import java.util.ArrayList;

public interface CategoryDAO {
	public abstract ArrayList<Category> categories();

	public abstract Category category(long idCategory);
}
