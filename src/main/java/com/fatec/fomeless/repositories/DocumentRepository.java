package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.Document;
import com.fatec.fomeless.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
