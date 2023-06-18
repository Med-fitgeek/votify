package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Survey;

import java.util.List;
import java.util.UUID;


public interface SurveyService {


    List<Survey> getAllSurveys();

    void save(Survey survey);

    Survey findByDescription(String entry);

    boolean deleteById(UUID id);
}
