package com.finanza.finanza_progetto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanza.finanza_progetto.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
