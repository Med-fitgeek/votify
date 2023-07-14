package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.repositories.ElectionRepository;
import com.ecpi.votify.services.ElectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ElectionServiceImpl implements ElectionService {

    @Autowired
    private ElectionRepository electionRepository;


    @Override
    public void save(Election election) {
        electionRepository.save(election);
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public Election findByDescription(String entry) {
        Optional<Election> election = electionRepository.findByDescription(entry);
        if (election.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return election.get();
    }

    @Override
    public Election findById(UUID id) {
        Optional<Election> election = electionRepository.findById(id);
        if (election.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return election.get();
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Election> election = electionRepository.findById(id);
        if (election.isEmpty())
            throw new EntityNotFoundException("Aucune election ne correspond aux inforations fournies");
        electionRepository.deleteById(id);
    }
}
