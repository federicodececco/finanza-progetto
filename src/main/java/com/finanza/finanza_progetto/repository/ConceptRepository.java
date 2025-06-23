package com.finanza.finanza_progetto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanza.finanza_progetto.model.Concept;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {

    Optional<Concept> findBySlug(String slug);

    List<Concept> findAllByNameContaining(String query);

}
