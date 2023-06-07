package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;


    public List<Survey> getAllSurveys(){
        return surveyRepository.findAll();
    }

    public void save(Survey survey){
        surveyRepository.save(survey);
    }

    public Survey findByDescription(String entry){
        return surveyRepository.findByDescription(entry);
    }

    public  void deleteById(UUID id){
        surveyRepository.deleteById(id);
    }
}
