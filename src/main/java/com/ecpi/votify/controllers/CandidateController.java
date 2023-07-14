package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidateList = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Candidate> addCandidate(@Valid @RequestBody Candidate candidate) {
        candidateService.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }

    @GetMapping("/findByFirstNameOrLastName")
    public ResponseEntity<Candidate> findByFirstnameOrLastname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Candidate candidate = candidateService.findByFirstnameOrLastname(firstName, lastName);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody @Valid Candidate candidate) {
        candidateService.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable UUID id) {
        candidateService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
