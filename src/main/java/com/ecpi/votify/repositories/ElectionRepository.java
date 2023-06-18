package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ElectionRepository extends JpaRepository<Election, UUID> {
    Optional<Election> findByDescription(String word);
}
