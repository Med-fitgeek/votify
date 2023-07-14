package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.repositories.CandidateRepository;
import com.ecpi.votify.services.CandidateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    @Override
    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findByFirstnameOrLastname(String first, String last) {
        Optional<Candidate> candidate = candidateRepository.findByFirstnameOrLastname(first, last);
        if (candidate.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return candidate.get();
    }

    @Override
    public Candidate findById(UUID id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return candidate.get();
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        candidateRepository.deleteById(id);

    }
}
