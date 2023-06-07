package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.repositories.PossibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PossibilityService {

    @Autowired
    private PossibilityRepository possibilityRepository;


    public List<Possibility> getAllPossibilities(){
        return possibilityRepository.findAll();
    }

    public void save(Possibility possibility){
        possibilityRepository.save(possibility);
    }

    public Possibility findByDescription(String entry){
        return possibilityRepository.findByDescription(entry);
    }

    public  void deleteById(UUID id){
        possibilityRepository.deleteById(id);
    }
}
