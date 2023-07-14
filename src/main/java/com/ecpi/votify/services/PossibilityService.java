package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Possibility;

import java.util.List;
import java.util.UUID;


public interface PossibilityService {


    void save(Possibility possibility);

    List<Possibility> getAllPossibilities();

    Possibility findByDescription(String entry);

    Possibility findById(UUID id);

    void deleteById(UUID id);
}
