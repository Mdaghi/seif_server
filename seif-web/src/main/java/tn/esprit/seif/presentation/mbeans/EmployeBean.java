package tn.esprit.seif.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.seif.persistence.Employe;
import tn.esprit.seif.persistence.Role;
import tn.esprit.seif.services.EmployeService;

@ManagedBean
@SessionScoped
public class EmployeBean {

	@EJB
	EmployeService employeService;
	
	private String prenom;
	private String nom;
	private String password;
	private String email;
	private boolean isActif;
	private Role role;
	private Integer id;
	


	private List<Employe> employes = new ArrayList<>();
	


	public void addEmploye()
	{
		Employe employe = new Employe();
		employe.setNom(nom);
		employe.setPrenom(prenom);
		employe.setEmail(email);
		employe.setActif(isActif);
		employe.setRole(role);
		employe.setPassword(password);
		employeService.ajouterEmploye(employe);
		reset();
	}
	public void modifierEmploye(Employe emp)
	{
		id = emp.getId();
		nom=emp.getNom();
		prenom=emp.getPrenom();
		email=emp.getEmail();
		isActif=emp.isActif();
		role=emp.getRole();
		
	}
	public void updateDBEmploye()
	{
		Employe employe = new Employe();
		System.out.println("id : " +id);
		employe.setId(id);
		employe.setNom(nom);
		employe.setPrenom(prenom);
		employe.setEmail(email);
		employe.setActif(isActif);
		employe.setRole(role);
		employe.setPassword(password);
		employeService.updateEmploye(employe);
		reset();
		
	}
	
	public void deleteEmploye(int id)
	{
		employeService.deleteEmploye(id);
	}
	public void reset()
	{
		password="";
		email="";
		nom="";
		prenom="";
		email="";
		isActif=false;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	
	public List<Employe> getEmployes() {
		return employeService.getAllEmploye();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

	

}
