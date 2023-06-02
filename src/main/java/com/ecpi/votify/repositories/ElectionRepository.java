package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.models.entities.election.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ElectionRepository extends JpaRepository<Election, UUID> {
    Election findByDescription(String word);
}
