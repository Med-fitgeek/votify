package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Candidate;

import java.util.List;
import java.util.UUID;

public interface CandidateService {

    List<Candidate> getAllCandidates();

    void save(Candidate candidate);

    Candidate findByFirstNameOrLastName(String first, String last);

    void deleteById(UUID id);
}
