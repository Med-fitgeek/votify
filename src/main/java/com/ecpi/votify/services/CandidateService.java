package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }

    public void save(Candidate candidate){
        candidateRepository.save(candidate);
    }

    public Candidate findByDescription(String first, String last){
        return candidateRepository.findByFirstNameOrLastName(first, last);
    }

    public  void deleteById(UUID id){
        candidateRepository.deleteById(id);
    }
}
