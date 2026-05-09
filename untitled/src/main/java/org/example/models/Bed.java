package org.example.models;

import jakarta.persistence.*;

@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean bezet;

    public boolean isBezet() { return bezet; }
    public void setBezet(boolean bezet) { this.bezet = bezet; }
}