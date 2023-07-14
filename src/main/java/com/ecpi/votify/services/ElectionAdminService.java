package com.ecpi.votify.services;

import com.ecpi.votify.models.dtos.ElectionAdminDTO;
import com.ecpi.votify.models.entities.ElectionAdmin;

import java.util.List;
import java.util.UUID;

public interface ElectionAdminService {

    void save(ElectionAdminDTO electionAdminDTO);

    List<ElectionAdmin> getAllElectionAdmins();

    ElectionAdmin findByFirstnameOrLastname(String first, String last);

    ElectionAdmin findById(UUID id);

    boolean isUserRegistered(String email, String nin, String password);

    void deleteById(UUID id);
}
