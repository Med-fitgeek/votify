package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters(){
        return voterRepository.findAll();
    }

    public void save(Voter voter){
        voterRepository.save(voter);
    }

    public Voter findByFirstNameOrLastName(String first, String last){
        return voterRepository.findByFirstNameOrLastName(first, last);
    }

    public boolean deleteById(UUID id) {
        if (voterRepository.existsById(id)) {
            voterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
