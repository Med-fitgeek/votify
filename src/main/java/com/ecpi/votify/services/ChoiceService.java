package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.survey.Choice;

import java.util.List;


public interface ChoiceService {

    void save(Choice choice);

    List<Choice> getAllChoices();
}
