package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Voter;

import java.util.List;
import java.util.UUID;


public interface VoterService {

    List<Voter> getAllVoters();

    void save(Voter voter);

    Voter findByFirstNameOrLastName(String first, String last);

    boolean deleteById(UUID id);
}
