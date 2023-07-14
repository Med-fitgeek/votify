package com.ecpi.votify.models.entities.survey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "choice")
public class Choice {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "possibility_id", insertable = false, updatable = false)
    private Possibility possibility;

}
