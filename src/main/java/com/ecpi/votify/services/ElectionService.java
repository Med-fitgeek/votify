package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepository;


    public List<Election> getAllElections(){
        return electionRepository.findAll();
    }

    public void save(Election election){
        electionRepository.save(election);
    }

    public Election findByDescription(String entry){
        return electionRepository.findByDescription(entry);
    }

    public  void deleteById(UUID id){
        electionRepository.deleteById(id);
    }
}
