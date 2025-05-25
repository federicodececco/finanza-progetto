package com.finanza.finanza_progetto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Concept;
import com.finanza.finanza_progetto.service.CategoryService;
import com.finanza.finanza_progetto.service.ConceptService;
import com.finanza.finanza_progetto.service.TagService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    @Autowired
    private ConceptService conceptService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public String index(Model model) {

        List<Concept> concepts = conceptService.findAll();
        model.addAttribute("concepts", concepts);
        return "concepts/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Concept> conceptOpt = conceptService.findById(id);
        model.addAttribute("concept", conceptOpt.get());
        model.addAttribute("tags", conceptOpt.get().getTags());
        model.addAttribute("category", conceptOpt.get().getCategory());
        return "concepts/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> levels = new ArrayList<String>();
        levels.add("basso");
        levels.add("medio");
        levels.add("alto");
        model.addAttribute("concept", new Concept());
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("levels", levels);
        return "concepts/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("concept") Concept formConcept, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            List<String> levels = new ArrayList<String>();
            levels.add("basso");
            levels.add("medio");
            levels.add("alto");
            model.addAttribute("tags", tagService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("levels", levels);
            return "/concepts/create-edit";
        }
        conceptService.create(formConcept);
        return "redirect:/concepts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Concept concept = conceptService.findById(id).get();
        List<String> levels = new ArrayList<String>();
        levels.add("BEGINNER");
        levels.add("INTERMEDIATE");
        levels.add("HARD");
        model.addAttribute("levels", levels);
        model.addAttribute("concept", concept);
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("tagsBelong", concept.getTags());
        model.addAttribute("categories", categoryService.findAll());
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
            model.addAttribute("tags", tagService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("edit", true);
            return "concepts/create-edit";
        }
        conceptService.edit(formConcept);
        return "redirect:/concepts/" + formConcept.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        conceptService.deleteById(id);
        return "redirect:/concepts";
    }
}
