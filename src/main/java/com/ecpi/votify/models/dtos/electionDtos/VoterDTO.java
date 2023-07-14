package com.ecpi.votify.models.dtos.electionDtos;

import com.ecpi.votify.models.dtos.UserDTO;
import com.ecpi.votify.models.entities.election.Vote;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VoterDTO extends UserDTO {

    @OneToOne
    @JoinColumn(name = "vote_id", insertable = false, updatable = false)
    @NotNull
    private Vote vote;

}
