package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.models.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {
    Survey findByDescription(String word);
}
