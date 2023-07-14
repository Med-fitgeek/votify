package com.ecpi.votify.models.entities.survey;

import com.ecpi.votify.models.entities.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "participant")
public class Participant extends User {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "choiceid", insertable = false, updatable = false)
    private Choice choice;

}
