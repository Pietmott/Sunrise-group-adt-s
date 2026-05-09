package org.example.Repositories;

import org.example.models.Slaaponderzoek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlaaponderzoekDAO extends JpaRepository<Slaaponderzoek, Long> { }