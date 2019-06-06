package tn.esprit.seif.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.seif.persistence.Contract;
import tn.esprit.seif.persistence.Employe;

@Remote
public interface EmployeServiceRemote {
	public int ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(Contract contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<Employe> getAllEmploye();
	public void deleteEmploye(int id);
	public void updateEmploye(Employe employe);
	public Employe getEmployeByEmailAndPassword(String login,String password);
}
