package be.odisee.brainstorm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.odisee.brainstorm.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findByEmailadres(String email);
	Patient findByVoornaam(String voornaam);
}
