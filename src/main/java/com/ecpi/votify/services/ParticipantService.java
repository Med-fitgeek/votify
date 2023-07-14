package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Participant;

import java.util.List;
import java.util.UUID;


public interface ParticipantService {

    void save(Participant participant);

    List<Participant> getAllParticipants();

    Participant findByFirstnameOrLastname(String first, String last);

    Participant findById(UUID id);

    void deleteById(UUID id);
}
