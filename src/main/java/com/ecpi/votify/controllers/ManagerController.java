package com.ecpi.votify.controllers;

import com.ecpi.votify.models.dtos.ManagerDTO;
import com.ecpi.votify.models.entities.Manager;
import com.ecpi.votify.services.ManagerService;
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
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Manager>> getAllElectionAdmins() {

        List<Manager> organizerList = managerService.getAllElectionAdmins();
        return new ResponseEntity<>(organizerList, HttpStatus.OK);
    }

    /*
        @PostMapping("/save")
        public ResponseEntity<ManagerDTO> addElectionAdmin(@Valid @RequestBody ManagerDTO electionAdminDTO) {
            managerService.save(electionAdminDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PostMapping("/isUserRegistered")
        public ResponseEntity<Boolean> isUserRegistered(
                @RequestParam("email") String email,
                @RequestParam("nin") String nin,
                @RequestParam("password") String password) {
            boolean userExists = managerService.isUserRegistered(email, nin, password);
            return new ResponseEntity<>(userExists, HttpStatus.OK);
        }

    */
    @GetMapping("/getUser")
    public ResponseEntity<Manager> findByFirstnameOrLastname(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        Manager organizer = managerService.findByFirstnameOrLastname(firstName, lastName);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Manager> findById(@PathVariable UUID id) {
        Manager organizer = managerService.findById(id);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ManagerDTO> updateElectionAdmin(@RequestBody @Valid ManagerDTO managerDTO) {
        managerService.save(managerDTO);
        return new ResponseEntity<>(managerDTO, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteElectionAdmin(@PathVariable UUID id) {
        managerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
