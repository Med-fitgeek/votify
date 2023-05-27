package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.repositories.ElectionRepository;
import com.ecpi.votify.repositories.VoteRepository;
import com.ecpi.votify.repositories.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoterService {
    private VoterRepository voterRepository;

    //Pour afficher la liste de toutes les electeurs
    public List<Voter> getAll(){
        return voterRepository.findAll();
    }

    /* methode pour Sauvegarder */
    public void save(Voter voter){
        voterRepository.save(voter);
    }

    /* methode pour faire la recherche */
    public void findByFirstName() {voterRepository.findByFirstNameOrLastName();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        voterRepository.deleteById(id);
        }

}
