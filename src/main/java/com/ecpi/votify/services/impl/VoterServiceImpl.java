package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.repositories.VoterRepository;
import com.ecpi.votify.services.VoterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public void save(Voter voter) {
        voterRepository.save(voter);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter findByFirstnameOrLastname(String first, String last) {
        Optional<Voter> voter = voterRepository.findByFirstnameOrLastname(first, last);
        if (voter.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return voter.get();
    }

    @Override
    public Voter findById(UUID id) {
        Optional<Voter> voter = voterRepository.findById(id);
        if (voter.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return voter.get();
    }

    public void deleteById(UUID id) {
        Optional<Voter> voter = voterRepository.findById(id);
        if (voter.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        voterRepository.deleteById(id);
    }
}
