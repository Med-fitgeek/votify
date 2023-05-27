package com.ecpi.votify.models.dtos.surveyDtos;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChoiceDTO {

    private UUID id;
    private PossibilityDTO possibility;

    // Les autres propriétés si nécessaire

}
