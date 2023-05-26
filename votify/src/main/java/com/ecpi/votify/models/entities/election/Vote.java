package com.ecpi.votify.models.entities.election;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vote {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "voterid", insertable = false, updatable = false)
    private Voter voter;

    @OneToOne
    @JoinColumn(name = "candidateid", insertable = false, updatable = false)
    private Candidate candidate;

}
