package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.repositories.PossibilityRepository;
import com.ecpi.votify.services.PossibilityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PossibilityServiceImpl implements PossibilityService {

    @Autowired
    private PossibilityRepository possibilityRepository;


    public void save(Possibility possibility) {
        possibilityRepository.save(possibility);
    }

    public List<Possibility> getAllPossibilities() {
        return possibilityRepository.findAll();
    }

    public Possibility findByDescription(String entry) {
        Optional<Possibility> possibility = possibilityRepository.findByDescription(entry);
        if (possibility.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return possibility.get();
    }

    @Override
    public Possibility findById(UUID id) {
        Optional<Possibility> possibility = possibilityRepository.findById(id);
        if (possibility.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return possibility.get();
    }

    public void deleteById(UUID id) {
        Optional<Possibility> possibility = possibilityRepository.findById(id);
        if (possibility.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        possibilityRepository.deleteById(id);
    }
}
