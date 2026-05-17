package be.odisee.brainstorm.service;

import be.odisee.brainstorm.domain.*;
import be.odisee.brainstorm.dao.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("brainstormSessieService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BedToewijzingServiceImpl implements BedToewijzingService {

    @Autowired
    private PatientRepository patientRepository = null;

    @Autowired
    private BedRepository bedRepository = null;

    public BedToewijzingServiceImpl(){}

    public List<Patient> geefAllePatienten() {
        return patientRepository.findAll();
    }

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Patient zoekPatientMetId(int id){
		Patient patient;
		
		Optional<Patient> optionalPatient = patientRepository.findById(id);
        if ( optionalPatient.isPresent() ) patient = optionalPatient.get();
        else patient = null; // in dat geval hebben we geen patient met dat id gevonden
		return patient;
    }
    
	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	@Override
	public Patient zoekPatientMetEmail(String email) {
		return patientRepository.findByEmailadres(email);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	@Override
	public Patient zoekPatientMetVoornaam(String voornaam) {
		return patientRepository.findByVoornaam(voornaam);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Patient voegPatientToe(String voornaam, String familienaam, String emailadres) {

    	return patientRepository.save( createPatient("aktief",voornaam,familienaam,emailadres) );
    }

    private Patient createPatient(String status, String voornaam, String familienaam, String emailadres) {

    	return new Patient(status, voornaam, familienaam, emailadres);
	}

    public List<Bed> geefAlleBedden() {
        return bedRepository.findAll();
    }

    public List<Bed> geefVrijeBedden() {
        return bedRepository.findByStatus(false);
    }

    public Bed zoekBedMetId(int id) {
        Optional<Bed> optionalBed = bedRepository.findById(id);
        return optionalBed.orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Patient wijsPatientAanBedToe(int patientId, int bedId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        Optional<Bed> optionalBed = bedRepository.findById(bedId);

        if (optionalPatient.isEmpty() || optionalBed.isEmpty()) {
            return null;
        }

        Patient patient = optionalPatient.get();
        Bed bed = optionalBed.get();

        if (patient.getBed() != null) {
            patient.getBed().setStatus(false);
            bedRepository.save(patient.getBed());
        }

        bed.setStatus(true);
        bedRepository.save(bed);

        patient.setBed(bed);
        return patientRepository.save(patient);
    }

}