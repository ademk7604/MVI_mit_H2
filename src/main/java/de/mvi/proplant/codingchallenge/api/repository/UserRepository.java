package de.mvi.proplant.codingchallenge.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mvi.proplant.codingchallenge.api.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
    List<User> findByUuid(UUID uuid);
}
