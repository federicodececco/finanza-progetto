package com.finanza.finanza_progetto.controller;

import com.finanza.finanza_progetto.repository.ConceptRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Category;
import com.finanza.finanza_progetto.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    ConceptRepository conceptRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "/categories/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        model.addAttribute("concepts", categoryRepository.findById(id).get().getConcepts());
        return "/categories/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("concepts", conceptRepository.findAll());
        return "/categories/create-edit";
    }

    @PostMapping("/create")
    public String postMethodName(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("concepts", conceptRepository.findAll());
            return "/categories/create-edit";
        }
        categoryRepository.save(formCategory);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("category", categoryRepository.findById(id).get());
        model.addAttribute("concepts", categoryRepository.findById(id).get().getConcepts());

        return "categories/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("concepts", categoryRepository.findById(formCategory.getId()).get().getConcepts());
            return "categories/create-edit";
        }
        categoryRepository.save(formCategory);
        return "redirect:/categories/" + formCategory.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "redirect:/categories";
    }

}
