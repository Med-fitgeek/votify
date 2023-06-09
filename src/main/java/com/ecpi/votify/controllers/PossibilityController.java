package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.services.PossibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/possibilities")
public class PossibilityController {

    @Autowired
    private PossibilityService possibilityService;

    @GetMapping
    public ResponseEntity<List<Possibility>> getAllPossibilities() {
        List<Possibility> possibilityList = possibilityService.getAllPossibilities();
        return new ResponseEntity<>(possibilityList, HttpStatus.OK);
    }

    @PostMapping("/addPossibility")
    public ResponseEntity<Possibility> addPossibility(@RequestBody Possibility possibility) {
        possibilityService.save(possibility);
        return new ResponseEntity<>(possibility, HttpStatus.CREATED);
    }

    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<Possibility> findByDescription(@PathVariable String description) {
        Possibility possibility = possibilityService.findByDescription(description);
        if (possibility != null) {
            return new ResponseEntity<>(possibility, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Possibility> updatePossibility(@RequestBody Possibility possibility) {
        possibilityService.save(possibility);
        return new ResponseEntity<>(possibility, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePossibility(@PathVariable UUID id) {
        boolean deleted = possibilityService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
