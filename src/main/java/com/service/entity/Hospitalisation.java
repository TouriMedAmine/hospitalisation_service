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
	String cinP;
	String cinM;
	long idAdmin;
	String duree;
	public Hospitalisation(String cinP, String cinM, long idAdmin, String duree) {
		super();
		this.cinP = cinP;
		this.cinM = cinM;
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
	public String getCinP() {
		return cinP;
	}
	public void setCinP(String cin) {
		this.cinP = cin;
	}
	public String getCinM() {
		return cinM;
	}
	public void setCinM(String cinM) {
		this.cinM = cinM;
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
