package com.ecpi.votify.models.entities.election;

import com.ecpi.votify.models.entities.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Candidate extends User {

    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "election_id", insertable = false, updatable = false)
    private Election election;
}

