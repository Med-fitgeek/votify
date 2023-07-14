package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.ElectionAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface ElectionAdminRepository extends JpaRepository<ElectionAdmin, UUID> {
    Optional<ElectionAdmin> findByFirstnameOrLastname(String firstName, String lastName);

    Optional<ElectionAdmin> findByEmailAndNinAndPassword(String email, String nin, String password);
}
