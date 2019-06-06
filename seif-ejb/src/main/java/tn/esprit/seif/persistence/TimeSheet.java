package tn.esprit.seif.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="TimeSheet")
public class TimeSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5155872582017973313L;

	
	@EmbeddedId
	private TimeSheetPK timeSheetpk;
	@ManyToOne
	@JoinColumn(name="idEmploye",referencedColumnName="id",insertable=false,updatable=false)
	private Employe employe;
	@ManyToOne
	@JoinColumn(name="idMission",referencedColumnName="id",insertable=false,updatable=false)
	private Mission mission;
	private int isValid;
	public TimeSheetPK getTimeSheetpk() {
		return timeSheetpk;
	}
	public void setTimeSheetpk(TimeSheetPK timeSheetpk) {
		this.timeSheetpk = timeSheetpk;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	
	
	
	
	
}
