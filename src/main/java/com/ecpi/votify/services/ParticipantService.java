package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Participant;
import com.ecpi.votify.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants(){
        return participantRepository.findAll();
    }

    public void save(Participant participant){
        participantRepository.save(participant);
    }

    public Participant findByDescription(String first, String last){
        return participantRepository.findByFirstNameOrLastName(first, last);
    }

    public  void deleteById(UUID id){
        participantRepository.deleteById(id);
    }
}
