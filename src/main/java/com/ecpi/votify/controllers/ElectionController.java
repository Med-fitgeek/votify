package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.election.Election;
import com.ecpi.votify.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @GetMapping("/elections")
    public String getAllElections(Model model) {

        List<Election> electionList = electionService.getAllElections();

        model.addAttribute("elections", electionList);

        return "election";
    }

    @PostMapping("/elections/addElection")
    public String addElection(Election election) {

        electionService.save(election);

        return "redirect:/elections";
    }

    @RequestMapping("/elections/findById/")
    @ResponseBody
    public Election findByDescription(String entry){

        return electionService.findByDescription(entry);
    }

    @RequestMapping(value="/elections/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Election election){
        electionService.save(election);
        return "redirect:/elections";
    }

    @RequestMapping(value="/elections/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        electionService.deleteById(id);

        return "redirect:/elections";
    }
}
