package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidateList = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }

    @PostMapping("/addCandidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        candidateService.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }

    @GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
    public ResponseEntity<Candidate> findByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
        Candidate candidate = candidateService.findByFirstNameOrLastName(firstName,lastName);
        if (candidate != null) {
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        candidateService.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable UUID id) {
        boolean deleted = candidateService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
