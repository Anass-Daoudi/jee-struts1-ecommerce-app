package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.Product;
import model.ProductDAOImpl;

public class ShoppingCartAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		ProductDAOImpl u = new ProductDAOImpl();

		if (session.getAttribute("shoppingCart") == null) {
			ArrayList<Product> shopping = new ArrayList<Product>();
			session.setAttribute("shoppingCart", shopping);
		}
		ArrayList<Product> shopping = (ArrayList<Product>) session.getAttribute("shoppingCart");
		if (request.getParameter("idProduct") != null) {
			shopping.add(u.getProduct(Long.parseLong(request.getParameter("idProduct"))));
		}
		try {
			PrintWriter out = response.getWriter();
			out.println(shopping.size());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
