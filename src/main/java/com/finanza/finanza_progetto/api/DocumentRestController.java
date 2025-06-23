package com.finanza.finanza_progetto.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://main.d3qgrorazttcr0.amplifyapp.com")
@RequestMapping("/api/documents")
public class DocumentRestController {

    @GetMapping("/download")
    public ResponseEntity<Resource> download() {
        try {

            ClassPathResource resource = new ClassPathResource("files/documentoimportantissimo.pdf");

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            String filename = "documentoimportantissimo.pdf";

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
