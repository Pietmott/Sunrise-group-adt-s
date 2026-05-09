package org.example.Services;

import org.example.Repositories.PatientDAO;
import org.example.Repositories.SlaaponderzoekDAO;
import org.example.models.Bed;
import org.example.models.Patient;
import org.example.models.Slaaponderzoek;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SlaaponderzoekService {

    @Autowired
    private SlaaponderzoekDAO slaaponderzoekDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private BedDAO bedDAO;

    // We passen hier specifiek Read Committed toe, zoals in je System Design staat.
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void planSlaaponderzoekIn(Long patientId, Long bedId) {

        // 1. Haal de patiënt en het bed op uit de database
        Patient patient = patientDAO.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patiënt niet gevonden met ID: " + patientId));

        Bed bed = bedDAO.findById(bedId)
                .orElseThrow(() -> new IllegalArgumentException("Bed niet gevonden met ID: " + bedId));

        // 2. Controleer of het bed daadwerkelijk vrij is (Consistentie bewaken)
        if (bed.isBezet()) {
            throw new IllegalStateException("Fout: Het bed is al bezet! Het inplannen wordt geannuleerd.");
        }

        // 3. Maak het nieuwe slaaponderzoek aan en koppel de patiënt
        Slaaponderzoek onderzoek = new Slaaponderzoek();
        onderzoek.setPatient(patient);
        onderzoek.setStatus("INGEPLAND");

        // 4. Reserveer het bed en koppel het aan het onderzoek
        bed.setBezet(true);
        onderzoek.setBed(bed);

        // 5. Sla de wijzigingen op in de database via de DAO
        bedDAO.save(bed);
        slaaponderzoekDAO.save(onderzoek);

    }
}