package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.User;
import model.UserDAOImpl;
import view.SignUpForm;

public class SignUpAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		UserDAOImpl u = new UserDAOImpl();
		SignUpForm f = (SignUpForm) af;
		User user = new User(f.getFirstName(), f.getLastName(), f.getEmail(), f.getPassword(), f.getCivility());

		if (u.exists(f.getEmail().trim())) {
			request.setAttribute("userExists", true);
			return am.findForward("userExists");
		}
		if (u.insert(user)) {
			return am.findForward("login");
		}
		request.setAttribute("userNotRegistered", true);
		return am.findForward("userNotRegistered");
	}
}
