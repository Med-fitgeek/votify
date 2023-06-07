package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Choice;
import com.ecpi.votify.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @GetMapping("/choices")
    public String getAllChoices(Model model) {

        List<Choice> choiceList = choiceService.getAllChoices();

        model.addAttribute("choices", choiceList);

        return "choice";
    }

    @PostMapping("/choices/addChoice")
    public String addChoice(Choice choice) {

        choiceService.save(choice);

        return "redirect:/choices";
    }

}
