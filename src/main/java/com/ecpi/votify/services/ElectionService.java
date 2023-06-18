package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Election;

import java.util.List;
import java.util.UUID;


public interface ElectionService {


    List<Election> getAllElections();

    void save(Election election);

    Election findByDescription(String entry);

    void deleteById(UUID id);
}
