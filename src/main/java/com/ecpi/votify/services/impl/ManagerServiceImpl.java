package com.ecpi.votify.services.impl;

import com.ecpi.votify.exceptions.ApiRequestException;
import com.ecpi.votify.models.dtos.ManagerDTO;
import com.ecpi.votify.models.entities.Manager;
import com.ecpi.votify.repositories.ManagerRepository;
import com.ecpi.votify.services.ManagerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void save(ManagerDTO managerDTO) {

        Manager admin = new Manager();
        admin.setFirstname(managerDTO.getFirstname());
        admin.setLastname(managerDTO.getLastname());
        admin.setEmail(managerDTO.getEmail());
        admin.setAddress(managerDTO.getAddress());
        admin.setPhone(managerDTO.getPhone());
        admin.setNin(managerDTO.getNin());
        admin.setPassword(managerDTO.getPassword());

        managerRepository.save(admin);
    }


    @Override
    public List<Manager> getAllElectionAdmins() {

        List<Manager> allAdmins = managerRepository.findAll();
        if (allAdmins.isEmpty())
            throw new ApiRequestException("Aucun organizateur trouvé");
        return allAdmins;
    }


    @Override
    public Manager findByFirstnameOrLastname(String first, String last) {
        Optional<Manager> admin = managerRepository.findByFirstnameOrLastname(first, last);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return admin.get();
    }


    @Override
    public Manager findById(UUID id) {
        Optional<Manager> admin = managerRepository.findById(id);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        return admin.get();
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Manager> admin = managerRepository.findById(id);
        if (admin.isEmpty())
            throw new EntityNotFoundException("Aucune entité ne correspond aux informations fournies.");
        managerRepository.deleteById(id);

    }


    @Override
    public boolean isUserRegistered(String email, String nin, String password) {
        Optional<Manager> admin = managerRepository.findByEmailAndNinAndPassword(email, nin, password);
        return admin.isPresent();
    }


}
