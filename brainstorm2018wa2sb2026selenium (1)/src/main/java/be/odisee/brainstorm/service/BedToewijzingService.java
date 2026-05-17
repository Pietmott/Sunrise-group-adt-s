package be.odisee.brainstorm.service;

import be.odisee.brainstorm.domain.*;
import java.util.List;

public interface BedToewijzingService {

    public List<Patient> geefAllePatienten();

    public Patient voegPatientToe(String voornaam, String familienaam, String emailadres);

    public Patient zoekPatientMetId(int id);

	public Patient zoekPatientMetEmail(String email);

    public Patient zoekPatientMetVoornaam(String voornaam);

    public List<Bed> geefAlleBedden();

    public List<Bed> geefVrijeBedden();

    public Bed zoekBedMetId(int id);

    public Patient wijsPatientAanBedToe(int patientId, int bedId);
}