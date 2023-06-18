package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Participant;
import com.ecpi.votify.services.impl.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantServiceImpl participantService;

    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants() {
        List<Participant> participantList = participantService.getAllParticipants();
        return new ResponseEntity<>(participantList, HttpStatus.OK);
    }

    @PostMapping("/addParticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant) {
        participantService.save(participant);
        return new ResponseEntity<>(participant, HttpStatus.CREATED);
    }

    @GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
    public ResponseEntity<Participant> findByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
        Participant participant = participantService.findByFirstNameOrLastName(firstName, lastName);
        return new ResponseEntity<>(participant, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) {
        participantService.save(participant);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable UUID id) throws Exception {
        participantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
