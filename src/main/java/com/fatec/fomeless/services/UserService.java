package com.fatec.fomeless.services;

import com.fatec.fomeless.dto.UserDTO;
import com.fatec.fomeless.entities.Document;
import com.fatec.fomeless.entities.Email;
import com.fatec.fomeless.entities.User;
import com.fatec.fomeless.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(UserDTO::new);
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User user = obj.orElseThrow();
        return new UserDTO(user);
    }
}
