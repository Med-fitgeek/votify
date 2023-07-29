package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findByFirstnameOrLastname(String firstName, String lastName);

    Optional<Manager> findByEmailAndNinAndPassword(String email, String nin, String password);

    Optional<Manager> findByEmail(String email);
}
