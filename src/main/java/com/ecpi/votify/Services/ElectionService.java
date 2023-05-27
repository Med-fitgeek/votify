package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.repositories.CandidateRepository;
import com.ecpi.votify.repositories.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ElectionService {
    private ElectionRepository electionRepository;

    //Pour afficher la liste de toutes les elections
    public List<Election> getAll(){
        return electionRepository.findAll();
    }

    /* methode pour Sauvegarder */
    public void save(Election election){
        electionRepository.save(election);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        electionRepository.findByDescription();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        electionRepository.deleteById(id);
        }

}
