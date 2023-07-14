package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.services.impl.PossibilityServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/possibilities")
public class PossibilityController {

    @Autowired
    private PossibilityServiceImpl possibilityService;

    @GetMapping
    public ResponseEntity<List<Possibility>> getAllPossibilities() {
        List<Possibility> possibilityList = possibilityService.getAllPossibilities();
        return new ResponseEntity<>(possibilityList, HttpStatus.OK);
    }

    @PostMapping("/addPossibility")
    public ResponseEntity<Possibility> addPossibility(@Valid @RequestBody Possibility possibility) {
        possibilityService.save(possibility);
        return new ResponseEntity<>(possibility, HttpStatus.CREATED);
    }

    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<Possibility> findByDescription(@PathVariable String description) {
        Possibility possibility = possibilityService.findByDescription(description);
            return new ResponseEntity<>(possibility, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Possibility> updatePossibility(@RequestBody Possibility possibility) {
        possibilityService.save(possibility);
        return new ResponseEntity<>(possibility, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePossibility(@PathVariable UUID id) {
        possibilityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
