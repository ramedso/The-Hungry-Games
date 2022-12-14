package com.fatec.fomeless.services;

import com.fatec.fomeless.dto.UserDTO;
import com.fatec.fomeless.dto.UserInsertDTO;
import com.fatec.fomeless.dto.UserUpdateDTO;
import com.fatec.fomeless.entities.User;
import com.fatec.fomeless.repositories.RoleRepository;
import com.fatec.fomeless.repositories.UserRepository;
import com.fatec.fomeless.services.exceptions.DatabaseException;
import com.fatec.fomeless.services.exceptions.InvalidEmailException;
import com.fatec.fomeless.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User user = obj.orElseThrow();
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User user = new User();
        dtoConversion(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserUpdateDTO dto) throws ResourceNotFoundException, InvalidEmailException {
        try {
            User user = repository.getReferenceById(id);
            dtoConversion(dto, user);
            user.setPassword(dto.getPassword());
            user = repository.save(user);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (Exception e) {
            throw new InvalidEmailException("");
        }
    }

    public void delete(Long id) throws ResourceNotFoundException {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    private void dtoConversion(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setSignUpDate(dto.getSignUpDate());
        entity.setEmail(dto.getEmail());

        entity.getRoles().clear();

        dto.getRoles().forEach(
                roleDTO -> entity.getRoles().add(
                        roleRepository.getReferenceById(roleDTO.getId())
                )
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;
    }
}
