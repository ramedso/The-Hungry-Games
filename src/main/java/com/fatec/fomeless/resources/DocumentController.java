package com.fatec.fomeless.resources;

import com.fatec.fomeless.dto.DocumentDTO;
import com.fatec.fomeless.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @GetMapping
    private ResponseEntity<Page<DocumentDTO>> findAll(Pageable pageable) {
        Page<DocumentDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }
}
