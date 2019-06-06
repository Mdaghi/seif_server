package tn.esprit.seif.interfaces;

import java.util.Date;

import javax.ejb.Remote;

import tn.esprit.seif.persistence.Mission;

@Remote
public interface TimesheetServiceRemote {
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
}
