package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/votes")
    public String getAllVotes(Model model) {

        List<Vote> voteList = voteService.getAllVotes();

        model.addAttribute("votes", voteList);

        return "vote";
    }

    @PostMapping("/votes/addVote")
    public String addVote(Vote vote) {

        voteService.save(vote);

        return "redirect:/votes";
    }

}
