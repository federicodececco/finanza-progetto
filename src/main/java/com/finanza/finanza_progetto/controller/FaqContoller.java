package com.finanza.finanza_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Faq;
import com.finanza.finanza_progetto.service.FaqService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/faq")
public class FaqContoller {

    @Autowired
    FaqService faqService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("faq", faqService.findAll());
        return "/faq/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("faq", faqService.findById(id).get());
        return "/faq/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("faq", new Faq());
        return "/faq/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("faq") Faq formAnswer, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/faq/create-edit";
        }
        faqService.create(formAnswer);
        return "redirect:/faq";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("faq", faqService.findById(id).get());

        return "/faq/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("faq") Faq formAnswer, Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/faq/create-edit";
        }
        faqService.edit(formAnswer);
        return "redirect:/faq" + formAnswer.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        faqService.deleteById(id);
        return "redirect:/faq";
    }

}
