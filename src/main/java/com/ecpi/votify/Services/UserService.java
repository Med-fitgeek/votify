package com.ecpi.votify.Services;

import com.ecpi.votify.models.entities.User;
import com.ecpi.votify.models.entities.election.Candidate;
import com.ecpi.votify.repositories.CandidateRepository;
import com.ecpi.votify.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    //Pour afficher la liste de tous les candidats
    public List<User> getAll(){
        return userRepository.findAll();
    }
    /* methode pour Sauvegarder */
    public void save(User user){
        userRepository.save(user);
    }

    /* methode pour faire la recherche */
    public void findByFirstName(){
        userRepository.findByFirstNameOrLastName();
    }

    //Methode pour supprimer une instance de la base de donnee
    public void delete(UUID id){
        userRepository.deleteById(id);
    }
}
