package com.ecpi.votify.controllers;

import com.ecpi.votify.models.dtos.ElectionAdminDTO;
import com.ecpi.votify.models.entities.ElectionAdmin;
import com.ecpi.votify.services.ElectionAdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/organizers")
public class ElectionAdminController {

    @Autowired
    private ElectionAdminService electionAdminService;

    @GetMapping("/fetchAll")
    public ResponseEntity<List<ElectionAdmin>> getAllElectionAdmins() {
        List<ElectionAdmin> organizerList = electionAdminService.getAllElectionAdmins();
        return new ResponseEntity<>(organizerList, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<ElectionAdminDTO> addElectionAdmin(@Valid @RequestBody ElectionAdminDTO electionAdminDTO) {
        electionAdminService.save(electionAdminDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/isUserRegistered")
    public ResponseEntity<Boolean> isUserRegistered(
            @RequestParam("email") String email,
            @RequestParam("nin") String nin,
            @RequestParam("password") String password) {
        boolean userExists = electionAdminService.isUserRegistered(email, nin, password);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }


    @GetMapping("/getUser")
    public ResponseEntity<ElectionAdmin> findByFirstnameOrLastname(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        ElectionAdmin organizer = electionAdminService.findByFirstnameOrLastname(firstName, lastName);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<ElectionAdmin> findById(@PathVariable UUID id) {
        ElectionAdmin organizer = electionAdminService.findById(id);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ElectionAdminDTO> updateElectionAdmin(@RequestBody @Valid ElectionAdminDTO electionAdminDTO) {
        electionAdminService.save(electionAdminDTO);
        return new ResponseEntity<>(electionAdminDTO, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteElectionAdmin(@PathVariable UUID id) {
        electionAdminService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
