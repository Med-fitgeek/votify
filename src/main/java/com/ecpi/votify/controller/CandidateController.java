package com.ecpi.votify.controller;

import com.ecpi.votify.Services.CandidateService;
import com.ecpi.votify.models.entities.election.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping("/candidates")
    public List<Candidate> getAll() {

        return service.getAll();
    }



}
