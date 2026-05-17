package be.odisee.brainstorm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.odisee.brainstorm.domain.Bed;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Integer> {
    List<Bed> findByStatus(boolean status);
}
