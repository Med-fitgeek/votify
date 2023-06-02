package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.models.entities.survey.Possibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PossibilityRepository extends JpaRepository<Possibility, UUID> {
}
