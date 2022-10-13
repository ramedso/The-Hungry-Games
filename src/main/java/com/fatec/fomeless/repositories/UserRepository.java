package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
