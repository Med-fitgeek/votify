package com.ecpi.votify.models.dtos.electionDtos;

import com.ecpi.votify.models.entities.election.Voter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ElectionDTO {

    @NotEmpty
    private String description;

    @NotEmpty
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startingDate;

    @NotEmpty
    private LocalTime startingTime;

    @NotEmpty
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private LocalDate endingDate;

    @NotEmpty
    private LocalTime endingTime;

    @OneToMany
    @JoinColumn(name = "voter_id", insertable = false, updatable = false)
    private List<Voter> voterList;
}
