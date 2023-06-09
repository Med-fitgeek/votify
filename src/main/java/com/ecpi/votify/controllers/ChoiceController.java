package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Choice;
import com.ecpi.votify.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @GetMapping
    public ResponseEntity<List<Choice>> getAllChoices() {
        List<Choice> choiceList = choiceService.getAllChoices();
        return new ResponseEntity<>(choiceList, HttpStatus.OK);
    }

    @PostMapping("/addChoice")
    public ResponseEntity<Choice> addChoice(@RequestBody Choice choice) {
        choiceService.save(choice);
        return new ResponseEntity<>(choice, HttpStatus.CREATED);
    }
}
