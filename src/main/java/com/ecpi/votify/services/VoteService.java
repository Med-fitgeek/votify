package com.ecpi.votify.services;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;


    public List<Vote> getAllVotes(){
        return voteRepository.findAll();
    }

    public void save(Vote vote){
        voteRepository.save(vote);
    }

}
