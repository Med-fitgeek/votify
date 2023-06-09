package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @GetMapping
    public ResponseEntity<List<Election>> getAllElections() {
        List<Election> electionList = electionService.getAllElections();
        return new ResponseEntity<>(electionList, HttpStatus.OK);
    }

    @PostMapping("/addElection")
    public ResponseEntity<Election> addElection(@RequestBody Election election) {
        electionService.save(election);
        return new ResponseEntity<>(election, HttpStatus.CREATED);
    }

    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<Election> findByDescription(@PathVariable String description) {
        Election election = electionService.findByDescription(description);
        if (election != null) {
            return new ResponseEntity<>(election, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Election> updateElection(@RequestBody Election election) {
        electionService.save(election);
        return new ResponseEntity<>(election, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteElection(@PathVariable UUID id) {
        boolean deleted = electionService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
