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

import model.Category;
import model.CategoryDAOImpl;

public class ShopCategoriesAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			CategoryDAOImpl u = new CategoryDAOImpl();
			ArrayList<Category> categories = u.categories();
			out.println(
					"<select id=\"categoryChoice\" onChange=\"products()\">");
			out.println("<option hidden value=\"chooseCategory\">Choose Category</option>");
			for (int i = 0; i < categories.size(); i++) {
				out.println("<option value='" + categories.get(i).getCategoryId() + "'>"
						+ categories.get(i).getCategoryEnum() + "</option>");
			}
			out.println("</select>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
