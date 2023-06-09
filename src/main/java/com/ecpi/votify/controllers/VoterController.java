package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        List<Voter> voterList = voterService.getAllVoters();
        return new ResponseEntity<>(voterList, HttpStatus.OK);
    }

    @PostMapping("/addVoter")
    public ResponseEntity<Voter> addVoter(@RequestBody Voter voter) {
        voterService.save(voter);
        return new ResponseEntity<>(voter, HttpStatus.CREATED);
    }

    @GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
    public ResponseEntity<Voter> findByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
        Voter voter = voterService.findByFirstNameOrLastName(firstName, lastName);
        if (voter != null) {
            return new ResponseEntity<>(voter, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Voter> updateVoter(@RequestBody Voter voter) {
        voterService.save(voter);
        return new ResponseEntity<>(voter, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVoter(@PathVariable UUID id) {
        boolean deleted = voterService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
