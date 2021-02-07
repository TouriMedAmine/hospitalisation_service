package com.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospitalisation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	long idPatient;
	long idMedcin;
	long idAdmin;
	String duree;
	public Hospitalisation(long idPatient, long idMedcin, long idAdmin, String duree) {
		super();
		this.idPatient = idPatient;
		this.idMedcin = idMedcin;
		this.idAdmin = idAdmin;
		this.duree = duree;
	}
	public Hospitalisation() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}
	public long getIdMedcin() {
		return idMedcin;
	}
	public void setIdMedcin(long idMedcin) {
		this.idMedcin = idMedcin;
	}
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	

}
