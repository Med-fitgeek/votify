package com.ecpi.votify.models.dtos.surveyDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ParticipantDTO extends UserDTO {

    @NotNull
    @OneToOne
    private ChoiceDTO choice;

}
