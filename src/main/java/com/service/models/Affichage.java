package com.service.models;

import com.service.entity.Hospitalisation;

public class Affichage {
	private Patient patient;
	private Hospitalisation hosp;
	public Affichage(Patient patient, Hospitalisation hosp) {
		super();
		this.patient = patient;
		this.hosp = hosp;
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
