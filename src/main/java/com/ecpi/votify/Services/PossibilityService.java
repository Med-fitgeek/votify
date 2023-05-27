package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.repositories.CandidateRepository;
import com.ecpi.votify.repositories.PossibilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PossibilityService {
    private PossibilityRepository possibilityRepository;

    //Pour afficher la liste de tous les candidats
    public List<Possibility> getAll(){
        return possibilityRepository.findAll();
    }
    /* methode pour Sauvegarder */
    public void save(Possibility possibility){
        possibilityRepository.save(possibility);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        possibilityRepository.findByDescription();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        possibilityRepository.deleteById(id);
    }
}
