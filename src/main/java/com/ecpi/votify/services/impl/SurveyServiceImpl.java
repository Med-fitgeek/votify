package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.repositories.SurveyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyServiceImpl {

    @Autowired
    private SurveyRepository surveyRepository;


    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public void save(Survey survey) {
        surveyRepository.save(survey);
    }

    public Survey findByDescription(String entry) {
        Optional<Survey> survey = surveyRepository.findByDescription(entry);
        if (survey.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        return survey.get();
    }

    public void deleteById(UUID id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        if (survey.isEmpty()) throw new EntityNotFoundException("Aucun ne correspond aux informations fournies.");
        surveyRepository.deleteById(id);
    }
}
