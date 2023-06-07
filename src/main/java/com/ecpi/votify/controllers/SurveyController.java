package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Survey;
import com.ecpi.votify.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys")
    public String getAllSurveys(Model model) {

        List<Survey> surveyList = surveyService.getAllSurveys();

        model.addAttribute("surveys", surveyList);

        return "survey";
    }

    @PostMapping("/surveys/addSurvey")
    public String addSurvey(Survey survey) {

        surveyService.save(survey);

        return "redirect:/surveys";
    }

    @RequestMapping("/surveys/findById/")
    @ResponseBody
    public Survey findByDescription(String entry){

        return surveyService.findByDescription(entry);
    }

    @RequestMapping(value="/surveys/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Survey survey){
        surveyService.save(survey);
        return "redirect:/surveys";
    }

    @RequestMapping(value="/surveys/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        surveyService.deleteById(id);

        return "redirect:/surveys";
    }
}
