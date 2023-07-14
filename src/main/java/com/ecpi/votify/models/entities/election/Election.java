package com.ecpi.votify.models.entities.election;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "election")
public class Election {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "startingDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startingDate;

    @Column(name = "startingTime")
    private LocalTime startingTime;

    @Column(name = "endingDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endingDate;

    @Column(name = "endingTime")
    private LocalTime endingTime;

    @OneToMany
    @JoinColumn(name = "voter_id", insertable = false, updatable = false)
    private List<Voter> voterList;

}
