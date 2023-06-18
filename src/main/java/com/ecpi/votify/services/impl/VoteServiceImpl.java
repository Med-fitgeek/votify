package com.ecpi.votify.services.impl;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl {

    @Autowired
    private VoteRepository voteRepository;


    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public void save(Vote vote) {
        voteRepository.save(vote);
    }

}
