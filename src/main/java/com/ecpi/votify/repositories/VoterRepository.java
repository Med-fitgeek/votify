package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VoterRepository extends JpaRepository<Voter, UUID> {
    Optional<Voter> findByFirstNameOrLastName(String firstName, String lastName);
}
