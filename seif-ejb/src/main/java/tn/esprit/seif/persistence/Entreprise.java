package tn.esprit.seif.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Entreprise")
public class Entreprise implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5083696858214242388L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	/*****/
	@Column(name = "name", nullable = true)
	private String name;
	/*****/
	@Column(name = "raisonSocial", nullable = true)
	private String raisonSocial;
	
	@OneToMany(mappedBy="entreprise",cascade=CascadeType.PERSIST)
	private List<Departement> departements;
	
	public Entreprise()
	{
		departements = new ArrayList<Departement>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public void addDepartement(Departement departement) {
		departement.setEntreprise(this);
		departements.add(departement);
	}
	
	
	
	
	
	

}
