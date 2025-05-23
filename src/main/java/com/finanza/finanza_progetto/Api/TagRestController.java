package com.finanza.finanza_progetto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanza.finanza_progetto.model.Tag;
import com.finanza.finanza_progetto.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/tags")
public class TagRestController {

    @Autowired
    TagService tagService;

    @GetMapping("")
    public List<Tag> index() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Integer id) {
        Optional<Tag> tagOpt = tagService.findById(id);
        if (tagOpt.isEmpty()) {
            return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tag>(tagOpt.get(), HttpStatus.OK);

    }

}
