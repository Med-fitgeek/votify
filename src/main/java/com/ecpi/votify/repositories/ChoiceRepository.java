package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Voter;
import com.ecpi.votify.models.entities.survey.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChoiceRepository extends JpaRepository<Choice, UUID> {
}
