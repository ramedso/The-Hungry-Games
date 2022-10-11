package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.Comment;
import com.fatec.fomeless.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
