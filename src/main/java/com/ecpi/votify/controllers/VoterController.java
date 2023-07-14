package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.services.impl.VoterServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/voters")
public class VoterController {

    @Autowired
    private VoterServiceImpl voterService;

    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        List<Voter> voterList = voterService.getAllVoters();
        return new ResponseEntity<>(voterList, HttpStatus.OK);
    }

    @PostMapping("/addVoter")
    public ResponseEntity<Voter> addVoter(@Valid @RequestBody Voter voter) {
        voterService.save(voter);
        return new ResponseEntity<>(voter, HttpStatus.CREATED);
    }

    @GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
    public ResponseEntity<Voter> findByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
        Voter voter = voterService.findByFirstnameOrLastname(firstName, lastName);
        return new ResponseEntity<>(voter, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Voter> updateVoter(@RequestBody Voter voter) {
        voterService.save(voter);
        return new ResponseEntity<>(voter, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVoter(@PathVariable UUID id) {
        voterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
