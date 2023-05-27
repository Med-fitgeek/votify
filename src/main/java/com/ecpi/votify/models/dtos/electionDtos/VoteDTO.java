package com.ecpi.votify.models.dtos.electionDtos;

import lombok.Data;

import java.util.UUID;

@Data
public class VoteDTO {
    private UUID id;

    private CandidateDTO candidate;
}
