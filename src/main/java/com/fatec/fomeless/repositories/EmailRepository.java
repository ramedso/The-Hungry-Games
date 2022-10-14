package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.Email;
import com.fatec.fomeless.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
