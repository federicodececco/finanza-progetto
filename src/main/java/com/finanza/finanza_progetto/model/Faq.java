package com.finanza.finanza_progetto.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String question;

    @OneToMany(mappedBy = "faq", cascade = { CascadeType.REMOVE })
    @JsonManagedReference
    private List<Answer> answers;

    public Faq(Integer id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers != null ? answers : new ArrayList<>();
    }

    public Faq() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        for (Answer answer : answers) {
            answer.setFaq(this);
        }
    }

    // return count emptu answers, it is neede for the thymeleaf form
    public void addEmptyAnswers(int count) {
        for (int i = 0; i < count; i++) {
            Answer answer = new Answer();
            answer.setFaq(this);
            this.answers.add(answer);
        }
    }
}
