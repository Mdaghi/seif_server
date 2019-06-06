package tn.esprit.seif.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name="Employe")
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7830472712503535725L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	/***/
	@Column(name = "nom", nullable = true)
	private String nom;
	/***/
	@Column(name = "prenom", nullable = true)
	private String prenom;
	/***/
	@Column(name = "email", nullable = true)
	private String email;
	/***/
	@Column(name = "isActif", nullable = true)
	private boolean isActif;
	/***/
	@Column(name = "role", nullable = true)
	private Role role;
	/***/
	@Column(name = "password", nullable = true)
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/***/
	
	
	@OneToMany(mappedBy="employe")
	private List<TimeSheet> timeSheets;
	
	@OneToOne(mappedBy="employe",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Contract contract;
	
	@ManyToMany(mappedBy="employes")
	private List<Departement> departements;
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public List<TimeSheet> getTimeSheets() {
		return timeSheets;
	}
	public void setTimeSheets(List<TimeSheet> timeSheets) {
		this.timeSheets = timeSheets;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", isActif=" + isActif
				+ ", role=" + role + ", password=" + password + ", contract=" + contract + "]";
	}
	
	
	
	
	
	

}
