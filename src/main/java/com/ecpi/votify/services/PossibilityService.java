package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Possibility;

import java.util.List;
import java.util.UUID;


public interface PossibilityService {


    List<Possibility> getAllPossibilities();

    void save(Possibility possibility);

    Possibility findByDescription(String entry);

    boolean deleteById(UUID id);
}
