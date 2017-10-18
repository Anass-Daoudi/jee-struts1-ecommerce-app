package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.CategoryDAOImpl;
import model.Product;
import model.ProductDAOImpl;
import model.User;
import view.AddProductForm;

public class AddProductAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ProductDAOImpl u = new ProductDAOImpl();
		AddProductForm f = (AddProductForm) af;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		FormFile formFile = f.getFile();
		String fileName = formFile.getFileName();
		File filePath = new File("C:\\Users\\hp\\workspace2\\ecommerce\\WebContent\\productImages\\" + user.getEmail());
		File fileNameFile = new File(filePath, fileName);

		if (!filePath.exists()) {
			filePath.mkdir();
		}
		if (fileNameFile.exists()) {
			request.setAttribute("error", "Rename your file!");
		} else {
			FileOutputStream fileOutStream = new FileOutputStream(fileNameFile);

			fileOutStream.write(formFile.getFileData());

			fileOutStream.flush();

			fileOutStream.close();
			CategoryDAOImpl u2 = new CategoryDAOImpl();
			long idCategory = Long.parseLong(f.getIdCategory());
			Product newProduct = new Product(f.getTitle(), f.getDescription(), Double.parseDouble(f.getPrice()),
					Long.parseLong(f.getQuantity()), u2.category(idCategory), user.getId(),
					"/ecommerce/productImages/" + user.getEmail() + "/" + fileName);
			u.insert(newProduct);
			ProductDAOImpl u3 = new ProductDAOImpl();
			user.setMyProducts(u3.myProducts(user.getId()));
		}

		return am.findForward("initAddProduct");
	}
}
