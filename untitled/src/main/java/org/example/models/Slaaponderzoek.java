package org.example.models;

import jakarta.persistence.*;

@Entity
public class Slaaponderzoek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @OneToOne
    private Bed bed;

    private String status;

    // Setters die je in je service aanroept
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setBed(Bed bed) { this.bed = bed; }
    public void setStatus(String status) { this.status = status; }
}