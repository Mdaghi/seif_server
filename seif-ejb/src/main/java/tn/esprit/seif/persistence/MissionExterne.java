package tn.esprit.seif.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="MissionExterne")
@DiscriminatorValue(value="MissionExterne")
public class MissionExterne extends Mission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2889724616093412524L;
	
	@Column(name = "emailFacturation", nullable = true)
	private String emailFacturation;
	
	@Column(name = "tauxJournalierMoyen", nullable = true)
	private Double tauxJournalierMoyen;

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public Double getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(Double tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}
	

	
}
