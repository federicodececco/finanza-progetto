package com.finanza.finanza_progetto.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanza.finanza_progetto.model.Faq;
import com.finanza.finanza_progetto.service.FaqService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "https://main.d3qgrorazttcr0.amplifyapp.com")
@RequestMapping("/api/faq")
public class FaqRestController {

    @Autowired
    private FaqService faqService;

    @GetMapping("")
    public List<Faq> index() {
        return faqService.findAll();
    }

}
