package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.services.impl.VoteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {

    @Autowired
    private VoteServiceImpl voteService;

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> voteList = voteService.getAllVotes();
        return new ResponseEntity<>(voteList, HttpStatus.OK);
    }

    @PostMapping("/addVote")
    public ResponseEntity<Vote> addVote(@Valid @RequestBody Vote vote) {
        voteService.save(vote);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
