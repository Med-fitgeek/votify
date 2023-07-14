package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Survey;

import java.util.List;
import java.util.UUID;


public interface SurveyService {

    void save(Survey survey);

    List<Survey> getAllSurveys();

    Survey findByDescription(String entry);

    Survey findById(UUID id);

    void deleteById(UUID id);
}
