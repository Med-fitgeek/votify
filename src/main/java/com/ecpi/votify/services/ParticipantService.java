package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Participant;

import java.util.List;
import java.util.UUID;


public interface ParticipantService {

    List<Participant> getAllParticipants();

    void save(Participant participant);

    Participant findByFirstNameOrLastName(String first, String last);

    boolean deleteById(UUID id);
}
