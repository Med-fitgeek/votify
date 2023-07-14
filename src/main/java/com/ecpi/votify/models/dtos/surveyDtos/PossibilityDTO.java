package com.ecpi.votify.models.dtos.surveyDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PossibilityDTO extends UserDTO {

    @NotEmpty
    private String description;
}
