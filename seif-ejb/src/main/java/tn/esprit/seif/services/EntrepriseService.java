package tn.esprit.seif.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.seif.interfaces.EntrepriseServiceRemote;
import tn.esprit.seif.persistence.Departement;
import tn.esprit.seif.persistence.Entreprise;

/**
 * Session Bean implementation class EntrepriseService
 */
@Stateless
public class EntrepriseService implements EntrepriseServiceRemote {

	

	@PersistenceContext(unitName = "seif-ejb")
	EntityManager em;

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		em.persist(entreprise);
		return entreprise.getId();
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		em.persist(dep);
		return dep.getId();
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Departement departement = em.find(Departement.class,depId);
		Entreprise entreprise = em.find(Entreprise.class,entrepriseId);
		departement.setEntreprise(entreprise);
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entreprise = em.find(Entreprise.class,entrepriseId);
		List<String> lst = new ArrayList<String>();
		for(Departement dep : entreprise.getDepartements())
		{
			lst.add(dep.getName());
		}
		return lst;
	}

}
