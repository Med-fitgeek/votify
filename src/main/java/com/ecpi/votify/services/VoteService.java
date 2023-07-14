package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Vote;

import java.util.List;


public interface VoteService {

    void save(Vote vote);

    List<Vote> getAllVotes();

}
