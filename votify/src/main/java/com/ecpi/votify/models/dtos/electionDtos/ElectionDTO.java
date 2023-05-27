package com.ecpi.votify.models.dtos.electionDtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ElectionDTO {

    private UUID id;
    private String description;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

}
