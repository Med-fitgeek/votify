package com.ecpi.votify.models.dtos.surveyDtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class SurveyDTO {

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
    @JoinColumn(name = "participant_id", insertable = false, updatable = false)
    private List<ParticipantDTO> participantList;

}
