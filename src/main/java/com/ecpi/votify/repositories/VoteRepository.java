package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.models.entities.election.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {
}
