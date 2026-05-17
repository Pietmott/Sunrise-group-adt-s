package be.odisee.brainstorm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// @Index bij een veld is deprecated, 
// jakarta.persistence.Index is te gebruiken en 
// die moet als deel van @Table worden meegegeven
@Entity
@Table(name="patiënten",
		indexes = { @Index(name="IPatiënt_naam",columnList="familienaam, voornaam"),
					@Index(name="IPatiënt_email",columnList="emailadres")
				} )
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // HV 201804015 tbv Gebruik AutoIncrement
    private int id;

    @Column
    private String voornaam;

    @Column
    private String familienaam;

    @Column
    private String emailadres;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    public Patient(){

    }

    public Patient(String status, String voornaam, String familienaam, String emailadres) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
    }

    public Patient(int id, String status, String voornaam, String familienaam, String emailadres) {
        this.id = id;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
    }

    public int getId() {
        return id;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

}