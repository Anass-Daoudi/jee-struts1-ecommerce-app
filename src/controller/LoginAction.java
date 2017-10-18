package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.ProductDAOImpl;
import model.User;
import model.UserDAOImpl;
import view.LoginForm;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse responseO) {
		UserDAOImpl u = new UserDAOImpl();
		LoginForm f = (LoginForm) af;
		User user = u.exists(f.getEmail().trim(), f.getPassword());

		if (user == null) {
			request.setAttribute("userNotFound", true);
			return am.findForward("userNotFound");
		}

		ProductDAOImpl u2 = new ProductDAOImpl();

		user.setMyProducts(u2.myProducts(user.getId()));

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return am.findForward("shop");
	}
}
