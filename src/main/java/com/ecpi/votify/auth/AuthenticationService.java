package com.ecpi.votify.auth;

import com.ecpi.votify.config.JwtService;
import com.ecpi.votify.models.entities.Manager;
import com.ecpi.votify.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private ManagerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public AuthenticationResponse register(RegisterRequest request) {

        Manager user = new Manager();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setNin(request.getNin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        repository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse login(LoginRequest request) {
        Manager user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        // Vérifier le mot de passe
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Mot de passe incorrect");
        }

        // Le mot de passe est correct, générer le jeton JWT
        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }
}
