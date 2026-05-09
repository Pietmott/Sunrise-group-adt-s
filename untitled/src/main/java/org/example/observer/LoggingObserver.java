package org.example.observer;

import org.example.models.Meting;
import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements SensorObserver {

    @Override
    public void update(Meting meting) {
        System.out.println("[OBSERVER LOG] Nieuwe meting ontvangen van patiënt ID: "
                + meting.getPatient().getId());
    }
}