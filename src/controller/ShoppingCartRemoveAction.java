package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.Product;

public class ShoppingCartRemoveAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		long idProduct = Long.parseLong(request.getParameter("idProduct"));
		HttpSession session = request.getSession();
		ArrayList<Product> shoppingCart = (ArrayList<Product>) session.getAttribute("shoppingCart");
		for (int i = 0; i < shoppingCart.size(); i++) {
			if (shoppingCart.get(i).getIdProduct() == idProduct) {
				shoppingCart.remove(i);
				break;
			}
		}
		return null;
	}
}
