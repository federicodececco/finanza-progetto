package com.finanza.finanza_progetto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanza.finanza_progetto.model.Concept;
import com.finanza.finanza_progetto.service.ConceptService;

@RestController
@RequestMapping("/api/concepts")
public class ConceptRestController {

    @Autowired
    ConceptService conceptService;

    @GetMapping("")
    public List<Concept> index() {
        return conceptService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concept> show(@PathVariable Integer id) {
        Optional<Concept> conceptOpt = conceptService.findById(id);
        if (conceptOpt.isEmpty()) {
            return new ResponseEntity<Concept>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Concept>(conceptOpt.get(), HttpStatus.OK);
    }

}
