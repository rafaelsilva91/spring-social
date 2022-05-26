package io.github.rafaelsilva91.springsocial.repositories;

import io.github.rafaelsilva91.springsocial.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
