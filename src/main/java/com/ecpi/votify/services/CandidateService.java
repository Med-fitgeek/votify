package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Candidate;

import java.util.List;
import java.util.UUID;

public interface CandidateService {

    void save(Candidate candidate);

    List<Candidate> getAllCandidates();

    Candidate findByFirstnameOrLastname(String first, String last);

    Candidate findById(UUID id);

    void deleteById(UUID id);
}
