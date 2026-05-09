package org.example.models;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;

    // Getters en Setters (belangrijk voor Hibernate!)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}