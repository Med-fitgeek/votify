package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.models.entities.survey.Participant;
import com.ecpi.votify.repositories.ElectionRepository;
import com.ecpi.votify.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;

    //Pour afficher la liste de toutes les elections
    public List<Participant> getAll(){
        return participantRepository.findAll();
    }

    /* methode pour Sauvegarder */
    public void save(Participant participant){
        participantRepository.save(participant);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        participantRepository.findByFirstNameOrLastName();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        participantRepository.deleteById(id);
        }

}
