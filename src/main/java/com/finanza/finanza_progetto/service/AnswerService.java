package com.finanza.finanza_progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanza.finanza_progetto.model.Answer;
import com.finanza.finanza_progetto.repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> findById(Integer id) {
        return answerRepository.findById(id);
    }

    public Answer create(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer edit(Answer answer) {
        return answerRepository.save(answer);
    }

    public void deleteById(Integer id) {
        answerRepository.deleteById(id);
    }
}
