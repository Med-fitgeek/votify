package com.ecpi.votify.repositories;

import com.ecpi.votify.models.entities.election.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ElectionRepository extends JpaRepository <Election, UUID> {
    Election findByDescription();
}
