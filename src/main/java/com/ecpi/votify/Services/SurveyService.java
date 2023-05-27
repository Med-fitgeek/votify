package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.repositories.ElectionRepository;
import com.ecpi.votify.repositories.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SurveyService {
    private SurveyRepository surveyRepository;

    //Pour afficher la liste de toutes les elections
    public List<Survey> getAll(){
        return surveyRepository.findAll();
    }

    /* methode pour Sauvegarder */
    public void save(Survey survey){
        surveyRepository.save(survey);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        surveyRepository.findByDescription();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        surveyRepository.deleteById(id);
        }

}
