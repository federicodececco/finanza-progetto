package com.finanza.finanza_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Answer;
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
        Faq faq = new Faq();
        faq.addEmptyAnswers(4); // thymeleaf form
        model.addAttribute("faq", faq);
        return "/faq/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("faq") Faq formFaq, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/faq/create-edit";
        }
        // removes the empty answers
        formFaq.getAnswers().removeIf(answer -> answer.getContent() == null || answer.getContent().trim().isEmpty());
        // it sets the answer to the faq
        for (Answer answer : formFaq.getAnswers()) {
            answer.setFaq(formFaq);
        }
        faqService.create(formFaq);
        return "redirect:/faq";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Faq faq = faqService.findById(id).get();
        // adds empty answer
        while (faq.getAnswers().size() < 4) {
            Answer answer = new Answer();
            answer.setFaq(faq);
            faq.getAnswers().add(answer);

        }

        model.addAttribute("faq", faq);
        model.addAttribute("edit", true);

        return "/faq/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("faq") Faq formFaq, Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/faq/create-edit";
        }

        formFaq.getAnswers().removeIf(answer -> answer.getContent() == null || answer.getContent().trim().isEmpty());
        // it sets the answer to the faq
        for (Answer answer : formFaq.getAnswers()) {
            answer.setFaq(formFaq);
        }

        faqService.edit(formFaq);
        return "redirect:/faq" + formFaq.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        faqService.deleteById(id);
        return "redirect:/faq";
    }

}
