package view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class AddProductForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private String price;
	private String quantity;
	private String idCategory;
	private FormFile file;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public ActionErrors validate(ActionMapping am, HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();

		String title = getTitle().trim();
		if (title.isEmpty()) {
			ae.add("notification", new ActionMessage("title.invalid"));
		} else {
			request.setAttribute("title", title);

			String description = getDescription().trim();
			if (description.isEmpty()) {
				ae.add("notification", new ActionMessage("description.invalid"));
			} else {
				request.setAttribute("description", description);

				try {
					double price = Double.parseDouble(getPrice().trim());
					request.setAttribute("price", price);

					try {
						long quantity = Long.parseLong(getQuantity().trim());

						request.setAttribute("quantity", quantity);
						try {
							long idCategory = Long.parseLong(getIdCategory());

							request.setAttribute("idCategory", idCategory);
						} catch (NumberFormatException e) {
							ae.add("notification", new ActionMessage("idCategory.invalid"));
						}
					} catch (NumberFormatException e) {
						ae.add("notification", new ActionMessage("quantity.invalid"));
					}
				} catch (NumberFormatException e) {
					ae.add("notification", new ActionMessage("price.invalid"));
				}
			}
		}

		return ae;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

}
