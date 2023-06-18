package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {
    Optional<Survey> findByDescription(String word);
}
