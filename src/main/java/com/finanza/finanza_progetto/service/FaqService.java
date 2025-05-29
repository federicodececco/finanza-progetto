package com.finanza.finanza_progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanza.finanza_progetto.model.Faq;
import com.finanza.finanza_progetto.repository.FaqRepository;

@Service
public class FaqService {

    @Autowired
    FaqRepository faqRepository;

    public List<Faq> findAll() {
        return faqRepository.findAll();
    }

    public Optional<Faq> findById(Integer id) {
        return faqRepository.findById(id);
    }

    public Faq create(Faq faq) {
        return faqRepository.save(faq);
    }

    public Faq edit(Faq faq) {
        return faqRepository.save(faq);
    }

    public void deleteById(Integer id) {
        faqRepository.deleteById(id);
    }

}
