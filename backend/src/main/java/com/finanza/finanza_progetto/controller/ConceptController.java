package com.finanza.finanza_progetto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Concept;
import com.finanza.finanza_progetto.repository.CategoryRepository;
import com.finanza.finanza_progetto.repository.ConceptRepository;
import com.finanza.finanza_progetto.repository.TagRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/create")
    public String create(Model model) {
        List<String> levels = new ArrayList<String>();
        levels.add("BEGINNER");
        levels.add("INTERMEDIATE");
        levels.add("HARD");
        model.addAttribute("concept", new Concept());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("levels", levels);
        return "concepts/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("concept") Concept formConcept, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            List<String> levels = new ArrayList<String>();
            levels.add("BEGINNER");
            levels.add("INTERMEDIATE");
            levels.add("HARD");
            model.addAttribute("tags", tagRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("levels", levels);
            return "/concepts/create-edit";
        }
        conceptRepository.save(formConcept);
        return "redirect:/concepts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Concept concept = conceptRepository.findById(id).get();
        List<String> levels = new ArrayList<String>();
        levels.add("BEGINNER");
        levels.add("INTERMEDIATE");
        levels.add("HARD");
        model.addAttribute("levels", levels);
        model.addAttribute("concept", concept);
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("tagsBelong", concept.getTags());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("categoryBelong", concept.getCategory());
        model.addAttribute("edit", true);
        return "concepts/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("concept") Concept formConcept, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            List<String> levels = new ArrayList<String>();
            levels.add("BEGINNER");
            levels.add("INTERMEDIATE");
            levels.add("HARD");
            model.addAttribute("levels", levels);
            model.addAttribute("tags", tagRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("edit", true);
            return "concepts/create-edit";
        }
        conceptRepository.save(formConcept);
        return "redirect:/concepts/" + formConcept.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Concept concept = conceptRepository.findById(id).get();

        conceptRepository.delete(concept);
        return "redirect:/concepts";
    }
}
