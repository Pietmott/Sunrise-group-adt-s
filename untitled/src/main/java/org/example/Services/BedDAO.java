package org.example.Services;

import org.example.models.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedDAO extends JpaRepository<Bed, Long> {
    // JpaRepository bevat standaard al methodes zoals save(), findById(), delete() etc.
}
