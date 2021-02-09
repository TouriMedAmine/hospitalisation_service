package com.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.service.entity.*;

@Repository
public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {
	@Query("select h from Hospitalisation h where h.cinP like :x")
	public List<Hospitalisation> chercherHospitalisationParCIN(@Param("x")String cin);
}
