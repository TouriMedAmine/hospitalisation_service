package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.entity.Hospitalisation;
import com.service.models.Affichage;
import com.service.models.Patient;
import com.service.repository.HospitalisationRepository;

@RestController
@RequestMapping("/hospitalisation")
public class HospitalisationController {
	@Autowired
	public HospitalisationRepository hospRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@PostMapping("/sauvegarder")
	public Hospitalisation sauvgarderHosp(@RequestBody Hospitalisation hosp) {
		return hospRepository.save(hosp);
	}
	
	@GetMapping("/{id}")
	public Hospitalisation trouverHospParId(@PathVariable("id") Long id) {
		return hospRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/detail/{id}")
	public Affichage afficherDetail(@PathVariable("id") Long id) {
		Affichage affichage = new Affichage();
		Hospitalisation hosp = hospRepository.findById(id).orElse(null);
		Patient patient = restTemplate.getForObject( "http://PATIENT-SERVICE/patient/"+hosp.getIdPatient(), 
									Patient.class);
		affichage.setPatient(patient);
		affichage.setHosp(hosp);
		return affichage;
	}

}
