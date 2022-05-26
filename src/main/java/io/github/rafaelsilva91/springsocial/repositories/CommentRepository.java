package io.github.rafaelsilva91.springsocial.repositories;

import io.github.rafaelsilva91.springsocial.entities.Comment;
import io.github.rafaelsilva91.springsocial.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
