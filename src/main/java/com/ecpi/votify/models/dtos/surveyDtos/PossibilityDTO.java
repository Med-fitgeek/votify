package com.ecpi.votify.models.dtos.surveyDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PossibilityDTO extends UserDTO {

    private UUID id;

    private String description;

    private SurveyDTO survey;

}
