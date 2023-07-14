package com.ecpi.votify.models.dtos.electionDtos;

import com.ecpi.votify.models.entities.election.Candidate;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteDTO {

    @OneToOne
    @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
    @NotNull
    private Candidate candidate;
}
