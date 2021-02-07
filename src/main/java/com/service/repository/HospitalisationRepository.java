package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.service.entity.*;

@Repository
public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {

}
