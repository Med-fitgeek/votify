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
@Table(name = "voter")
public class Voter extends User {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "vote_id", insertable = false, updatable = false)
    private Vote vote;

}
