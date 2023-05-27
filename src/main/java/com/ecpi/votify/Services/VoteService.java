package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.election.Vote;
import com.ecpi.votify.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteService {

    private VoteRepository voteRepository;

    private List<Vote> getAll(){
        return voteRepository.findAll();
    }
}
