package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Participant;
import com.ecpi.votify.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/participants")
    public String getAllParticipants(Model model) {

        List<Participant> participantList = participantService.getAllParticipants();

        model.addAttribute("participants", participantList);

        return "participant";
    }

    @PostMapping("/participants/addParticipant")
    public String addParticipant(Participant participant) {

        participantService.save(participant);

        return "redirect:/participants";
    }

    @RequestMapping("/participants/findById/")
    @ResponseBody
    public Participant findByDescription(String firstName, String lastName){

        return participantService.findByDescription(firstName, lastName);
    }

    @RequestMapping(value="/participants/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Participant participant){
        participantService.save(participant);
        return "redirect:/participants";
    }

    @RequestMapping(value="/participants/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        participantService.deleteById(id);

        return "redirect:/participants";
    }
}
