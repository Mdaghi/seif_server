package tn.esprit.seif.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import tn.esprit.seif.persistence.Employe;
import tn.esprit.seif.services.EmployeService;




@ManagedBean
@RequestScoped
public class LoginBean {
	@EJB
	EmployeService employeService;
	
	private String password;
	private String login;
	private Employe employe;
	private boolean loggedIn;
	
	public String doLogin()
	{
		String navigateTo = "";
		employe = employeService.getEmployeByEmailAndPassword(login,password);
		if(employe != null )
		{
			navigateTo = "/pages/welcome?face-redirect=true";
			loggedIn = true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials"));
		}
		return navigateTo;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
