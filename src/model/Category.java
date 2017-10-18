package model;

public class Category {
	private long idCategory;
	private CategoryEnum categoryEnum;

	public Category(long idCategory, String categoryEnum) {
		this.idCategory = idCategory;
		if (categoryEnum.equals("ALL")) {
			this.categoryEnum = CategoryEnum.ALL;
		} else if (categoryEnum.equals("ELECTRONICS")) {
			this.categoryEnum = CategoryEnum.ELECTRONICS;
		} else if (categoryEnum.equals("VEHICLES")) {
			this.categoryEnum = CategoryEnum.VEHICLES;
		} else if (categoryEnum.equals("BOOKS")) {
			this.categoryEnum = CategoryEnum.BOOKS;
		} else if (categoryEnum.equals("CLOTHING")) {
			this.categoryEnum = CategoryEnum.CLOTHING;
		} else if (categoryEnum.equals("HOUSES")) {
			this.categoryEnum = CategoryEnum.HOUSES;
		}
	}

	public CategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	public long getCategoryId() {
		return idCategory;
	}
}
