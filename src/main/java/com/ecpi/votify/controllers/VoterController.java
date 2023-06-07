package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/voters")
    public String getAllVoters(Model model) {

        List<Voter> voterList = voterService.getAllVoters();

        model.addAttribute("voters", voterList);

        return "voter";
    }

    @PostMapping("/voters/addVoter")
    public String addVoter(Voter voter) {

        voterService.save(voter);

        return "redirect:/voters";
    }

    @RequestMapping("/voters/findById/")
    @ResponseBody
    public Voter findByDescription(String firstName, String lastName){

        return voterService.findByDescription(firstName, lastName);
    }

    @RequestMapping(value="/voters/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Voter voter){
        voterService.save(voter);
        return "redirect:/voters";
    }

    @RequestMapping(value="/voters/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        voterService.deleteById(id);

        return "redirect:/voters";
    }
}
