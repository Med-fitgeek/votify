package com.ecpi.votify.models.dtos.surveyDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ParticipantDTO extends UserDTO {

    private UUID id;
    private ChoiceDTO choice;
    private SurveyDTO survey;

}
