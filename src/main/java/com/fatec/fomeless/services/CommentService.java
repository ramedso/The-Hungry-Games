package com.fatec.fomeless.services;

import com.fatec.fomeless.dto.CommentDTO;
import com.fatec.fomeless.entities.Comment;
import com.fatec.fomeless.repositories.CommentRepository;
import com.fatec.fomeless.services.exceptions.DatabaseException;
import com.fatec.fomeless.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Optional;

@Service
public class CommentService implements Serializable {

    @Autowired
    private CommentRepository repository;

    @Transactional(readOnly = true)
    public Page<CommentDTO> findAll(Pageable pageable) {
        Page<Comment> list = repository.findAll(pageable);
        return list.map(CommentDTO::new);
    }

    @Transactional(readOnly = true)
    public CommentDTO findById(Long id) {
        Optional<Comment> obj = repository.findById(id);
        Comment comment = obj.orElseThrow();
        return new CommentDTO(comment);
    }

    @Transactional
    public CommentDTO insert(CommentDTO dto) {
        Comment comment = new Comment();
        dtoToEntity(dto, comment);
        comment = repository.save(comment);
        return new CommentDTO(comment);
    }

    @Transactional
    public CommentDTO update(Long id, CommentDTO dto) throws ResourceNotFoundException {
        try {
            Comment comment = repository.getReferenceById(id);
            dtoToEntity(dto, comment);
            comment = repository.save(comment);
            return new CommentDTO(comment);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException, DatabaseException {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void dtoToEntity(CommentDTO dto, Comment entity) {
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setUser(dto.getUser());
        entity.setPost(dto.getPost());
    }
}
