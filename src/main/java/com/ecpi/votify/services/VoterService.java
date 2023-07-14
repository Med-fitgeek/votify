package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Voter;

import java.util.List;
import java.util.UUID;


public interface VoterService {

    void save(Voter voter);

    List<Voter> getAllVoters();

    Voter findByFirstnameOrLastname(String first, String last);

    Voter findById(UUID id);

    void deleteById(UUID id);
}
