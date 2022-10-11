package com.fatec.fomeless.repositories;

import com.fatec.fomeless.entities.GenericUser;
import com.fatec.fomeless.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
