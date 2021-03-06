package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.ProductDAOImpl;

public class ShopAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		ProductDAOImpl u = new ProductDAOImpl();
		request.setAttribute("allProducts", u.allProducts());
		return am.findForward("shop");
	}
}
