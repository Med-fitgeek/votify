package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;

    //Pour afficher la liste de tous les candidats
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }
    /* methode pour Sauvegarder */
    public void save(Candidate candidate){
        candidateRepository.save(candidate);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        candidateRepository.findByFirstNameOrLastName();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        candidateRepository.deleteById(id);
    }
}
