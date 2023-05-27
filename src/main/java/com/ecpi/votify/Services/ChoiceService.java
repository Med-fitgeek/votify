package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.models.entities.survey.Choice;
import com.ecpi.votify.repositories.ChoiceRepository;
import com.ecpi.votify.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;

    private List<Choice> getAll(){
        return choiceRepository.findAll();
    }
}
