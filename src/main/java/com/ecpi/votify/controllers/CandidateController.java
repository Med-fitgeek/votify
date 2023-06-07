package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public String getAllCandidates(Model model) {

        List<Candidate> candidateList = candidateService.getAllCandidates();

        model.addAttribute("candidates", candidateList);

        return "candidate";
    }

    @PostMapping("/candidates/addCandidate")
    public String addCandidate(Candidate candidate) {

        candidateService.save(candidate);

        return "redirect:/candidates";
    }

    @RequestMapping("/candidates/findById/")
    @ResponseBody
    public Candidate findByDescription(String firstName, String lastName){

        return candidateService.findByDescription(firstName, lastName);
    }

    @RequestMapping(value="/candidates/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Candidate candidate){
        candidateService.save(candidate);
        return "redirect:/candidates";
    }

    @RequestMapping(value="/candidates/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        candidateService.deleteById(id);

        return "redirect:/candidates";
    }
}
