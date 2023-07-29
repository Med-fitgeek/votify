package com.ecpi.votify.services;

import com.ecpi.votify.models.dtos.ManagerDTO;
import com.ecpi.votify.models.entities.Manager;

import java.util.List;
import java.util.UUID;

public interface ManagerService {

    void save(ManagerDTO managerDTO);

    List<Manager> getAllElectionAdmins();

    Manager findByFirstnameOrLastname(String first, String last);

    Manager findById(UUID id);

    boolean isUserRegistered(String email, String nin, String password);

    void deleteById(UUID id);
}
