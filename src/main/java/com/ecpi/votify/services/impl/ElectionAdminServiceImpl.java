package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.dtos.ElectionAdminDTO;
import com.ecpi.votify.models.entities.ElectionAdmin;
import com.ecpi.votify.repositories.ElectionAdminRepository;
import com.ecpi.votify.services.ElectionAdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ElectionAdminServiceImpl implements ElectionAdminService {

    @Autowired
    private ElectionAdminRepository electionAdminRepository;

    @Override
    public void save(ElectionAdminDTO electionAdminDTO) {

        ElectionAdmin admin = new ElectionAdmin();
        admin.setFirstname(electionAdminDTO.getFirstname());
        admin.setLastname(electionAdminDTO.getLastname());
        admin.setEmail(electionAdminDTO.getEmail());
        admin.setAddress(electionAdminDTO.getAddress());
        admin.setPhone(electionAdminDTO.getPhone());
        admin.setNin(electionAdminDTO.getNin());
        admin.setPassword(electionAdminDTO.getPassword());

        electionAdminRepository.save(admin);
    }


    @Override
    public List<ElectionAdmin> getAllElectionAdmins() {
        return electionAdminRepository.findAll();
    }


    @Override
    public ElectionAdmin findByFirstnameOrLastname(String first, String last) {
        Optional<ElectionAdmin> admin = electionAdminRepository.findByFirstnameOrLastname(first, last);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return admin.get();
    }


    @Override
    public ElectionAdmin findById(UUID id) {
        Optional<ElectionAdmin> admin = electionAdminRepository.findById(id);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return admin.get();
    }

    @Override
    public void deleteById(UUID id) {
        Optional<ElectionAdmin> admin = electionAdminRepository.findById(id);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        electionAdminRepository.deleteById(id);

    }


    @Override
    public boolean isUserRegistered(String email, String nin, String password) {
        Optional<ElectionAdmin> admin = electionAdminRepository.findByEmailAndNinAndPassword(email, nin, password);
        return admin.isPresent();
    }


}
