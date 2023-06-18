package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Possibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PossibilityRepository extends JpaRepository<Possibility, UUID> {

    Optional<Possibility> findByDescription(String entry);
}
