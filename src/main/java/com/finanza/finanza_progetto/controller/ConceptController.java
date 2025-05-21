package com.finanza.finanza_progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Concept;
import com.finanza.finanza_progetto.repository.CategoryRepository;
import com.finanza.finanza_progetto.repository.ConceptRepository;
import com.finanza.finanza_progetto.repository.TagRepository;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    @Autowired
    private ConceptRepository conceptRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String index(Model model) {

        List<Concept> concepts = conceptRepository.findAll();
        model.addAttribute("concepts", concepts);
        return "concepts/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Concept concept = conceptRepository.findById(id).get();
        model.addAttribute("concept", concept);
        model.addAttribute("tags", concept.getTags());
        model.addAttribute("category", concept.getCategory());
        return "concepts/show";
    }

}
