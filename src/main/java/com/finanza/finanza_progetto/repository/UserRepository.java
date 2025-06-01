package com.finanza.finanza_progetto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanza.finanza_progetto.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
