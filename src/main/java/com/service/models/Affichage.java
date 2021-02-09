package com.service.models;

import com.service.entity.Hospitalisation;

public class Affichage {
	private Patient patient;
	private Hospitalisation hosp;
	private Medecin medecin;
	
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Affichage(Patient patient, Hospitalisation hosp, Medecin medecin) {
		super();
		this.patient = patient;
		this.hosp = hosp;
		this.medecin = medecin;
	}
	public Affichage() {
		super();
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Hospitalisation getHosp() {
		return hosp;
	}
	public void setHosp(Hospitalisation hosp) {
		this.hosp = hosp;
	}
	
}
