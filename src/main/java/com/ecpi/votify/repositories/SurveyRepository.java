package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {
    Survey findByDescription();
}
