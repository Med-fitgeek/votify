package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.services.impl.ElectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    @Autowired
    private ElectionServiceImpl electionService;

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
    public ResponseEntity<Optional<Election>> findByDescription(@PathVariable String description) {
        Optional<Election> election = Optional.ofNullable(electionService.findByDescription(description));
        return new ResponseEntity<>(election, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Election> updateElection(@RequestBody Election election) {
        electionService.save(election);
        return new ResponseEntity<>(election, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteElection(@PathVariable UUID id) {
        electionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
