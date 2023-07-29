package com.ecpi.votify.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @Email(message = "L'adresse e-mail doit être au format valide")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Le mot de passe est obligatoire")
    @Column(name = "password")
    private String password;

}
