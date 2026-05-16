package org.example.Facades;

import org.example.Services.SlaaponderzoekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlaaponderzoekFacade {

    @Autowired
    private SlaaponderzoekService slaaponderzoekService;

    public void planSlaaponderzoek(Long patientId, Long bedId) {
        System.out.println("Facade: start planning slaaponderzoek");
        slaaponderzoekService.planSlaaponderzoekIn(patientId, bedId);
        System.out.println("Facade: slaaponderzoek succesvol ingepland");
    }
}