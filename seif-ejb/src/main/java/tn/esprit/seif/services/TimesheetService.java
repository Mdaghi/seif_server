package tn.esprit.seif.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.seif.interfaces.TimesheetServiceRemote;
import tn.esprit.seif.persistence.Departement;
import tn.esprit.seif.persistence.Mission;
import tn.esprit.seif.persistence.TimeSheet;
import tn.esprit.seif.persistence.TimeSheetPK;

/**
 * Session Bean implementation class TimesheetService
 */
@Stateless
public class TimesheetService implements TimesheetServiceRemote {

	@PersistenceContext(unitName = "seif-ejb")
	EntityManager em;
	

	@Override
	public int ajouterMission(Mission mission) {
		em.persist(mission);
		return mission.getId();
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission mission = em.find(Mission.class,missionId);
		Departement departement = em.find(Departement.class,depId);
		mission.setDepartement(departement);
		em.merge(mission);		
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimeSheetPK timeSheetPk = new TimeSheetPK();
		timeSheetPk.setIdEmploye(employeId);
		timeSheetPk.setIdMission(missionId);
		timeSheetPk.setDateDebut(dateDebut);
		timeSheetPk.setDateFin(dateFin);
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setTimeSheetpk(timeSheetPk);
		timeSheet.setIsValid(0);
		em.persist(timeSheet);
	}

}
