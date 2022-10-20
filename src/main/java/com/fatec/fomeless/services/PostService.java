package com.fatec.fomeless.services;

import com.fatec.fomeless.dto.PostDTO;
import com.fatec.fomeless.entities.Comment;
import com.fatec.fomeless.entities.Post;
import com.fatec.fomeless.repositories.CommentRepository;
import com.fatec.fomeless.repositories.PostRepository;
import com.fatec.fomeless.services.exceptions.DatabaseException;
import com.fatec.fomeless.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements Serializable {

    @Autowired
    private PostRepository repository;

    @Transactional(readOnly = true)
    public Page<PostDTO> findAll(Pageable pageable) {
        Page<Post> list = repository.findAll(pageable);
        return list.map(x -> new PostDTO(x, x.getComments()));
    }

    @Transactional(readOnly = true)
    public PostDTO findById(Long id) {
        Optional<Post> obj = repository.findById(id);
        Post post = obj.orElseThrow();
        return new PostDTO(post, post.getComments());
    }

    @Transactional
    public PostDTO insert(PostDTO dto) {
        Post post = new Post();
        dtoToEntity(dto, post);
        post = repository.save(post);
        return new PostDTO(post);
    }

    @Transactional
    public PostDTO update(Long id, PostDTO dto) throws ResourceNotFoundException {
        try {
            Post post = repository.getReferenceById(id);
            dtoToEntity(dto, post);
            post = repository.save(post);
            return new PostDTO(post);
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

    private void dtoToEntity(PostDTO dto, Post entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setThreadOpen(entity.isThreadOpen());
    }
}
