package com.finanza.finanza_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Tag;
import com.finanza.finanza_progetto.repository.TagRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("tags", tagRepository.findAll());
        return "/tags/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("tag", tagRepository.findById(id).get());
        model.addAttribute("concepts", tagRepository.findById(id).get().getConcepts());
        return "/tags/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("tag", new Tag());
        return "/tags/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("tag") Tag tagForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "/tags/create-edit";
        }
        tagRepository.save(tagForm);
        return "redirect:/tags";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("tag", tagRepository.findById(id).get());
        model.addAttribute("edit", true);

        return "/tags/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("tag") Tag tagForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "/tags/create-edit";
        }

        tagRepository.save(tagForm);
        return "redirect:/tags/" + tagForm.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        tagRepository.delete(tagRepository.findById(id).get());

        return "redirect:/tags";
    }

}
