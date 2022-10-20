package com.fatec.fomeless.resources;

import com.fatec.fomeless.dto.PostDTO;
import com.fatec.fomeless.services.PostService;
import com.fatec.fomeless.services.exceptions.DatabaseException;
import com.fatec.fomeless.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<Page<PostDTO>> findAll(Pageable pageable) {
        Page<PostDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id) {
        PostDTO postDTO = service.findById(id);
        return ResponseEntity.ok(postDTO);
    }

    @PostMapping
    private ResponseEntity<PostDTO> insert(@Valid @RequestBody PostDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id,@Valid @RequestBody PostDTO dto) throws ResourceNotFoundException {
        PostDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDTO> delete(@PathVariable Long id) throws ResourceNotFoundException, DatabaseException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
