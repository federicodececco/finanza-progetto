package com.finanza.finanza_progetto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The content cannot be null, blanck or empty")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faq_id", nullable = false)
    @JsonBackReference
    private Faq faq;

    public Answer(Integer id, @NotBlank(message = "The content cannot be null, blanck or empty") String content,
            Faq faq) {
        this.id = id;
        this.content = content;
        this.faq = faq;
    }

    public Answer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

}
