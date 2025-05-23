package com.finanza.finanza_progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanza.finanza_progetto.model.Tag;
import com.finanza.finanza_progetto.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Integer id) {
        return tagRepository.findById(id);
    }

    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag edit(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }
}
