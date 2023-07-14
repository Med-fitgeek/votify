package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.services.impl.SurveyServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveyList = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveyList, HttpStatus.OK);
    }

    @PostMapping("/addSurvey")
    public ResponseEntity<Survey> addSurvey(@Valid @RequestBody Survey survey) {
        surveyService.save(survey);
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }

    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<Survey> findByDescription(@PathVariable String description) {
        Survey survey = surveyService.findByDescription(description);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey) {
        surveyService.save(survey);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable UUID id) {
        surveyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
