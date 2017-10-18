package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.Product;
import model.ProductDAOImpl;

public class ShopProductAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {

		ProductDAOImpl u = new ProductDAOImpl();
		ArrayList<Product> products;
		if (request.getParameter("idCategory").equals("1")) {
			products = u.allProducts();
		} else {
			products = u.allProduct(Long.parseLong(request.getParameter("idCategory")));
		}
		try {
			PrintWriter out = response.getWriter();
			out.println("<table border=\"1\" width=\"70%\" cellspacing=\"0\" cellpadding=\"0\">");

			for (int i = 0; i < products.size(); i++) {
				out.println("<tr>");
				out.println("<td height=\"70\" width=\"30%\" align=\"center\"><img src='"
						+ products.get(i).getImageURL() + "' width='200' height='150' /></td>");
				out.println("<td height=\"70\" width=\"70%\" align=\"center\">" + products.get(i) + "</td>");
				out.println("<td height=\"70\" width=\"70%\" align=\"center\"><input onClick=\"shoppingCart("
						+ products.get(i).getIdProduct() + ")\" type=\"button\" value=\"Add To Shopping cart\" />"
						+ "</td>");
				out.println("<tr>");

			}
			out.println("</table>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
