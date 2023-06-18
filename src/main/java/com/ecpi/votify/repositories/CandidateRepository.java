package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    Optional<Candidate> findByFirstNameOrLastName(String firstName, String lastName);
}
