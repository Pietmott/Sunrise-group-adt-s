package org.example.models;

import jakarta.persistence.*;

@Entity
public class Meting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Slaaponderzoek slaaponderzoek;

    private String waarde;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Slaaponderzoek getSlaaponderzoek() { return slaaponderzoek; }
    public void setSlaaponderzoek(Slaaponderzoek slaaponderzoek) { this.slaaponderzoek = slaaponderzoek; }

    public String getWaarde() { return waarde; }
    public void setWaarde(String waarde) { this.waarde = waarde; }
}