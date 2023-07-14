package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Election;

import java.util.List;
import java.util.UUID;


public interface ElectionService {

    void save(Election election);

    List<Election> getAllElections();

    Election findById(UUID id);

    void deleteById(UUID id);

    Election findByDescription(String entry);

}
