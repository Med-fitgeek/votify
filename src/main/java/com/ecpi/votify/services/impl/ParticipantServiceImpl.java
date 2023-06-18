package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.survey.Participant;
import com.ecpi.votify.repositories.ParticipantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParticipantServiceImpl {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    public Participant findByFirstNameOrLastName(String first, String last) throws Exception {
        Optional<Participant> participant = participantRepository.findByFirstNameOrLastName(first, last);
        if (participant.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return participant.get();
    }

    public void deleteById(UUID id) throws Exception {
        Optional<Participant> participant = participantRepository.findById(id);
        if (participant.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        participantRepository.deleteById(id);
    }
}
