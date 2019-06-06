package tn.esprit.seif.services;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.seif.interfaces.EmployeServiceRemote;
import tn.esprit.seif.persistence.Contract;
import tn.esprit.seif.persistence.Departement;
import tn.esprit.seif.persistence.Employe;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote {

	@PersistenceContext(unitName = "seif-ejb")
	EntityManager em;

	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Employe employe = em.find(Employe.class, employeId);
		Departement departement = em.find(Departement.class, depId);
		departement.getEmployes().add(employe);
		em.merge(departement);
	}

	@Override
	public int ajouterContrat(Contract contrat) {
		em.persist(contrat);
		return contrat.getReference();
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contract contrat = em.find(Contract.class, contratId);
		Employe employe = em.find(Employe.class, employeId);
		contrat.setEmploye(employe);
		em.merge(contrat);
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		return em.find(Employe.class, employeId).getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		String jpql = "select count(e) from Employe e";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		String jpql = "select e from Employe e";
		TypedQuery<Employe> query = em.createQuery(jpql, Employe.class);
		List<Employe> lst = query.getResultList();
		List<String> names = new ArrayList<>();
		for (Employe e : lst) {
			names.add(e.getNom());
		}
		return names;
	}

	@Override
	public List<Employe> getAllEmploye() {
		String jpql = "select e from Employe e";
		TypedQuery<Employe> query = em.createQuery(jpql, Employe.class);
		return query.getResultList();
	}

	@Override
	public void deleteEmploye(int id) {
		Employe employe = em.find(Employe.class, id);
		em.remove(employe);
	}

	@Override
	public void updateEmploye(Employe employe) {
		Employe emp = em.find(Employe.class, employe.getId());
		emp.setActif(employe.isActif());
		emp.setEmail(employe.getEmail());
		emp.setNom(employe.getNom());
		emp.setPassword(employe.getPassword());
		emp.setPrenom(employe.getPrenom());
		emp.setRole(employe.getRole());
		em.merge(emp);

	}

	@Override
	public Employe getEmployeByEmailAndPassword(String login, String password) {
		String jpql = "select e from Employe e where e.email=:email and e.password=:password";
		TypedQuery<Employe> query = em.createQuery(jpql, Employe.class);
		query.setParameter("email", login);
		query.setParameter("password", password);
		return query.getSingleResult();

	}
	
	/*
	@Override
	public List<Employe> getAllEmployeWithContract() {
		String jpql = "select e from Employe e";
		TypedQuery<Employe> query = em.createQuery(jpql, Employe.class);
		return query.getResultList();
	}*/

}
