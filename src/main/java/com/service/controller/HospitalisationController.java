package com.service.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.entity.Hospitalisation;
import com.service.models.Affichage;
import com.service.models.Medecin;
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
	
	@GetMapping("/all")
	public List<Hospitalisation> afficherTous(){
		return hospRepository.findAll();
		
	}
	@PutMapping("editer/{id}")
	public Hospitalisation editerHospParId(@RequestBody Hospitalisation hosp) {
		Hospitalisation hospModifier = hospRepository.findById(hosp.getId()).orElse(null);
		hospModifier.setCinM(hosp.getCinM());
		hospModifier.setCinP(hosp.getCinP());
		hospModifier.setDuree(hosp.getDuree());
		hospModifier.setIdAdmin(hosp.getIdAdmin());
		return hospRepository.save(hospModifier);
	}

	@GetMapping("/detail/{id}")
	@HystrixCommand(fallbackMethod = "callPatientPersonnelServiceAndGetData_Fallback")
	public Affichage afficherDetail(@PathVariable("id") Long id) {
		Affichage affichage = new Affichage();
		Hospitalisation hosp = hospRepository.findById(id).orElse(null);
		Patient patient = restTemplate.getForObject("http://PATIENT-SERVICE/patient/cin/" + hosp.getCinP(),
				Patient.class);
		Medecin medecin = restTemplate.getForObject(
				"http://PERSONNEL-SERVICE/Personnel/Medecin/medecinByCin/" + hosp.getCinM(), Medecin.class);
		affichage.setPatient(patient);
		affichage.setMedecin(medecin);
		affichage.setHosp(hosp);
		return affichage;
	}

	private Affichage callPatientPersonnelServiceAndGetData_Fallback(Long id) {

		System.out.println("Probleme du Patient service ou medecin service!!! fallback route enabled...");
		Affichage affichage = new Affichage();
		Hospitalisation hosp = hospRepository.findById(id).orElse(null);
		affichage.setHosp(hosp);
		return affichage;
	}
	@GetMapping("/cinPatient/{cin}")
	List<Hospitalisation> listeHospitalisationParCinP(@PathVariable("cin") String cinP){
		List<Hospitalisation> hospitalisations = hospRepository.chercherHospitalisationParCIN(cinP);
		return hospitalisations;
	}
}

