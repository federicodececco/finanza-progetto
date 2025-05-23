package com.finanza.finanza_progetto.controller;

import com.finanza.finanza_progetto.service.CategoryService;
import com.finanza.finanza_progetto.service.ConceptService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ConceptService conceptService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/categories/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id).get());
        model.addAttribute("concepts", categoryService.findById(id).get().getConcepts());
        return "/categories/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("concepts", conceptService.findAll());
        return "/categories/create-edit";
    }

    @PostMapping("/create")
    public String postMethodName(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("concepts", conceptService.findAll());
            return "/categories/create-edit";
        }
        categoryService.create(formCategory);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("category", categoryService.findById(id).get());
        model.addAttribute("concepts", categoryService.findById(id).get().getConcepts());

        return "categories/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            model.addAttribute("concepts", categoryService.findById(formCategory.getId()).get().getConcepts());
            return "categories/create-edit";
        }
        categoryService.edit(formCategory);
        return "redirect:/categories/" + formCategory.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }

}
