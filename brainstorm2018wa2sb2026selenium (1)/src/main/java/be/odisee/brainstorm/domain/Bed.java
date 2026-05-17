package be.odisee.brainstorm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="sessies")
public class Bed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private boolean status;

    @Column
    private String locatie;

    public Bed(){}

    public Bed(int id, boolean status, String titel) {
        this.id = id;
        this.status = status;
        this.locatie = titel;
    }

    public Bed(boolean status, String titel) {
        this.status = status;
        this.locatie = titel;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}






























