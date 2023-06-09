package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveyList = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveyList, HttpStatus.OK);
    }

    @PostMapping("/addSurvey")
    public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
        surveyService.save(survey);
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }

    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<Survey> findByDescription(@PathVariable String description) {
        Survey survey = surveyService.findByDescription(description);
        if (survey != null) {
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey) {
        surveyService.save(survey);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable UUID id) {
        boolean deleted = surveyService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
