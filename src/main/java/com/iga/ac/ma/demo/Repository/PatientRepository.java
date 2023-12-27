package com.iga.ac.ma.demo.Repository;

import com.iga.ac.ma.demo.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends JpaRepository<Patient,Long> {
Page<Patient>findByNameContains(String keyword,Pageable pageable);
}
