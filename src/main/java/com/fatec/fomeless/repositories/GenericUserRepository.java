package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericUserRepository extends JpaRepository<GenericUser, Long> {
}
