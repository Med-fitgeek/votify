package com.ecpi.votify.models.dtos.electionDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class VoterDTO extends UserDTO {
    private UUID id;
    private VoteDTO vote;
    private VoterDTO voter;
}
