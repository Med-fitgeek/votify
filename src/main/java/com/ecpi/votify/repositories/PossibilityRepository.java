package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Possibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PossibilityRepository extends JpaRepository<Possibility, UUID> {
    Possibility findByDescription();
}
