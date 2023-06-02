package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.models.entities.survey.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    Participant findByFirstNameOrLastName(String firstName, String lastName);
}
