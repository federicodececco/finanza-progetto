package com.finanza.finanza_progetto.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "concepts")
public class Concept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty, null or blanck!")
    private String name;

    @NotBlank(message = "descritpion cannot be empty,null or blanck!")
    private String description;

    @Lob
    private String fullDescription;

    private String imgUrl;

    @NotBlank(message = "level must be equal to BEGINNER, INTERMEDIATE or HARD")
    private String level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonManagedReference
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "concept_tag", joinColumns = @JoinColumn(name = "concept_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonManagedReference
    private Set<Tag> tags;

    public Concept(Integer id, String name, String description, String fullDescription, String imgUrl, String level) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fullDescription = fullDescription;
        this.imgUrl = imgUrl;
        this.level = level;

    }

    public Concept() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

}