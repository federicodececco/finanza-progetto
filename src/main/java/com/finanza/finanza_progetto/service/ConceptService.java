package com.finanza.finanza_progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanza.finanza_progetto.model.Concept;
import com.finanza.finanza_progetto.repository.ConceptRepository;

@Service
public class ConceptService {

    @Autowired
    ConceptRepository conceptRepository;

    public List<Concept> findAll() {
        return conceptRepository.findAll();
    }

    public Optional<Concept> findById(Integer id) {
        return conceptRepository.findById(id);
    }

    public Concept create(Concept concept) {
        return conceptRepository.save(concept);
    }

    public Concept edit(Concept concept) {
        return conceptRepository.save(concept);
    }

    public void deleteById(Integer id) {
        conceptRepository.deleteById(id);
    }

    public Optional<Concept> findBySlug(String slug) {
        return conceptRepository.findBySlug(slug);
    }

}
