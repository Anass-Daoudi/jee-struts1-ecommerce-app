package view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import model.Email;

public class LoginForm extends ActionForm {
	private final static long serialVersionUID = 1L;
	private String email;
	private String password;

	public ActionErrors validate(ActionMapping am, HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();
		request.setAttribute("notification", true);

		if (!Email.validEmail(getEmail().trim())) {
			ae.add("notification", new ActionMessage("email.invalid"));
		} else {
			request.setAttribute("email", getEmail().trim());

			if (getPassword().isEmpty()) {
				ae.add("notification", new ActionMessage("password.invalid"));
			} else {
				request.setAttribute("password", getPassword().trim());

				if (request.getAttribute("userNotFound") != null) {
					ae.add("notification", new ActionMessage("authentication.invalid"));
				}
			}
		}
		return ae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
