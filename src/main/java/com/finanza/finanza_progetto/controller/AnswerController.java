package com.finanza.finanza_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finanza.finanza_progetto.model.Answer;

import com.finanza.finanza_progetto.service.AnswerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("answers", answerService.findAll());
        return "/answers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("answer", answerService.findById(id).get());
        return "/answers/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("answer", new Answer());
        return "/answers/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("answer") Answer formAnswer, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/answers/create-edit";
        }
        answerService.create(formAnswer);
        return "redirect:/answers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("answer", answerService.findById(id).get());

        return "/answers/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("answer") Answer formAnswer, Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/answers/create-edit";
        }
        answerService.edit(formAnswer);
        return "redirect:/answers" + formAnswer.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        answerService.deleteById(id);
        return "redirect:/answers";
    }

}
