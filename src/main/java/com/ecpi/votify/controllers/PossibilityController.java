package com.ecpi.votify.controllers;

import com.ecpi.votify.models.entities.survey.Possibility;
import com.ecpi.votify.services.PossibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class PossibilityController {

    @Autowired
    private PossibilityService possibilityService;

    @GetMapping("/possibilitys")
    public String getAllPossibilitys(Model model) {

        List<Possibility> possibilityList = possibilityService.getAllPossibilities();

        model.addAttribute("possibilitys", possibilityList);

        return "possibility";
    }

    @PostMapping("/possibilitys/addPossibility")
    public String addPossibility(Possibility possibility) {

        possibilityService.save(possibility);

        return "redirect:/possibilitys";
    }

    @RequestMapping("/possibilitys/findById/")
    @ResponseBody
    public Possibility findByDescription(String entry){

        return possibilityService.findByDescription(entry);
    }

    @RequestMapping(value="/possibilitys/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Possibility possibility){
        possibilityService.save(possibility);
        return "redirect:/possibilitys";
    }

    @RequestMapping(value="/possibilitys/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(UUID id){

        possibilityService.deleteById(id);

        return "redirect:/possibilitys";
    }
}
