package tn.esprit.seif.presentation.mbeans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.seif.persistence.Contract;
import tn.esprit.seif.persistence.Employe;
import tn.esprit.seif.services.EmployeService;

@ManagedBean
@SessionScoped
public class ContratBean {

	private String typeContrat;
	private Double salaire;
	private Date dateDebut;
	private List<Employe> employes;
	private List<Employe> employesContrat;
	private List<Employe> employesSansContrat;
	public List<Employe> getEmployesSansContrat() {
		return employesSansContrat;
	}

	public void setEmployesSansContrat(List<Employe> employesSansContrat) {
		this.employesSansContrat = employesSansContrat;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@EJB
	EmployeService employeService;

	@PostConstruct
	public void init() {
		employes = new ArrayList<>();
		employesContrat = new ArrayList<>();
		employes = employeService.getAllEmploye();
		for (Employe e : employes) {
			if (e.getContract() != null)
				employesContrat.add(e);
		}
		employesSansContrat = employes;
		employesSansContrat.removeAll(employesContrat);
		dateDebut = new Date();
		typeContrat = "CDI";
		
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	public void addContrat()
	{
		/***
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.err.println(simpleFormat.format(dateDebut));
		***/
		Contract contrat = new Contract();
		contrat.setSalaire(salaire);
		contrat.setDateDebut(dateDebut);
		contrat.setTypeContrat(typeContrat);
		/*******/
		Employe tmp = new Employe();
		tmp.setId(id);
		contrat.setEmploye(tmp);
		/*******/
		employeService.ajouterContrat(contrat);
		init();
	}

	public List<Employe> getEmployesContrat() {
		return employesContrat;
	}

	public void setEmployesContrat(List<Employe> employesContrat) {
		this.employesContrat = employesContrat;
	}
	
}
