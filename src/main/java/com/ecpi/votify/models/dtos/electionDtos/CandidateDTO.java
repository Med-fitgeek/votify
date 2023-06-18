package com.ecpi.votify.models.dtos.electionDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CandidateDTO extends UserDTO {

    private UUID id;
    @NotEmpty(message = "")
    private String firstName;
    @NotNull
    private ElectionDTO election;
    private Integer electionId;

    // Les autres propriétés de la classe User si nécessaire

}
