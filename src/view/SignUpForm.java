package view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import model.Email;

public class SignUpForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String passwordConfirmation;
	private String civility;

	public ActionErrors validate(ActionMapping am, HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();

		request.setAttribute("notification", true);
		if (getFirstName().trim().isEmpty()) {
			ae.add("notification", new ActionMessage("firstName.invalid"));
		} else {
			request.setAttribute("firstName", getFirstName().trim());

			if (getLastName().trim().isEmpty()) {
				ae.add("notification", new ActionMessage("lastName.invalid"));
			} else {
				request.setAttribute("lastName", getLastName().trim());

				if (!Email.validEmail(getEmail().trim())) {
					ae.add("notification", new ActionMessage("email.invalid"));
				} else {
					request.setAttribute("email", getEmail().trim());

					if (getPassword().isEmpty()) {
						ae.add("notification", new ActionMessage("password.invalid"));
					} else {
						request.setAttribute("password", getPassword());

						if (getPasswordConfirmation().isEmpty()) {
							ae.add("notification", new ActionMessage("passwordConfirmation.invalid"));
						} else {
							request.setAttribute("passwordConfirmation", getPasswordConfirmation());

							if (!getPassword().equals(getPasswordConfirmation())) {
								ae.add("notification", new ActionMessage("passwordPasswordConfirmation.invalid"));
							} else {
								if (getCivility() == null) {
									ae.add("notification", new ActionMessage("civility.invalid"));
								} else {
									request.setAttribute("civility", getCivility());

									if (request.getAttribute("userExists") != null) {
										ae.add("notification", new ActionMessage("userExists.invalid"));
									} else if (request.getAttribute("userNotRegistered") != null) {
										ae.add("notification", new ActionMessage("userNotRegistered.invalid"));
									}
								}
							}
						}

					}
				}

			}
		}

		return ae;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

}
