package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository <Candidate, UUID> {
     Candidate findByFirstNameOrLastName() ;
}
