package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    Optional<Participant> findByFirstnameOrLastname(String firstname, String lastname);

}
