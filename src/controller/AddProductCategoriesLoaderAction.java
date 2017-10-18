package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.Category;
import model.CategoryDAOImpl;

public class AddProductCategoriesLoaderAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		CategoryDAOImpl u = new CategoryDAOImpl();

		ArrayList<Category> categories = u.categories();
		request.setAttribute("categories", categories);

		return am.findForward("addProduct");
	}
}
