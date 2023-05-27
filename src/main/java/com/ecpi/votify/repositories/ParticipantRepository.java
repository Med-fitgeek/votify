package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    Participant findByFirstNameOrLastName();
}
