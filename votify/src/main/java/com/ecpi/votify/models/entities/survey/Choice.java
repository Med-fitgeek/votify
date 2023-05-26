package com.ecpi.votify.models.entities.survey;

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
public class Choice {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "participantid", insertable = false, updatable = false)
    private Participant participant;

    @OneToOne
    @JoinColumn(name = "candidateid", insertable = false, updatable = false)
    private Choice choice;

}
