package com.finanza.finanza_progetto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanza.finanza_progetto.model.Category;
import com.finanza.finanza_progetto.service.CategoryService;

@RestController
@CrossOrigin(origins = "https://splendorous-zuccutto-f57e63.netlify.app")
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> index() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> show(@PathVariable Integer id) {
        Optional<Category> categoryOpt = categoryService.findById(id);
        if (categoryOpt.isEmpty()) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(categoryOpt.get(), HttpStatus.OK);

    }
}
