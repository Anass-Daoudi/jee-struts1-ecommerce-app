package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.ProductDAOImpl;
import model.User;

public class RemoveProductMyStoreAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		ProductDAOImpl u = new ProductDAOImpl();

		String[] arr = u.getProduct(Long.parseLong(request.getParameter("idProduct"))).getImageURL().split("/");

		File file = new File("C:/Users/hp/workspace2/ecommerce/WebContent/" + arr[2] + "/" + arr[3] + "/" + arr[4]);
		file.delete();
		u.removeProduct(Long.parseLong(request.getParameter("idProduct")));
		User user = ((User) session.getAttribute("user"));
		user.setMyProducts(u.myProducts(user.getId()));
		return null;
	}
}
