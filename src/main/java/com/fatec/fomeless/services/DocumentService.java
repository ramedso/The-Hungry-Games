package com.fatec.fomeless.services;

import com.fatec.fomeless.dto.DocumentDTO;
import com.fatec.fomeless.entities.Document;
import com.fatec.fomeless.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository repository;

    public Page<DocumentDTO> findAllPaged(Pageable pageable) {
        Page<Document> list = repository.findAll(pageable);
        return list.map(DocumentDTO::new);
    }
}
