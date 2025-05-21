package com.finanza.finanza_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.repository.ConceptRepository;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    @Autowired
    private ConceptRepository conceptRepository;

    @GetMapping("")
    public String index() {
        return "";
    }
}
