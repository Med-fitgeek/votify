package com.ecpi.votify.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterRequest {

    @NotEmpty(message = "Le prénom est obligatoire")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Le nom de famille est obligatoire")
    @Column(name = "lastname")
    private String lastname;

    @Email(message = "L'adresse e-mail doit être au format valide")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    //@Pattern(regexp = "\\d+", message = "Le numéro de téléphone doit contenir uniquement des chiffres")
    @NotEmpty(message = "Le numéro de téléphone est obligatoire")
    @Column(name = "phone")
    private String phone;

    @NotEmpty(message = "Le numéro d'identité est obligatoire")
    @Column(name = "nin")
    private String nin;

    @NotEmpty(message = "Le mot de passe est obligatoire")
    @Column(name = "password")
    private String password;

}


