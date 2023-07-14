package com.ecpi.votify.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

    @NotEmpty(message = "Le prénom est obligatoire")
    private String firstname;

    @NotEmpty(message = "Le nom de famille est obligatoire")
    private String lastname;

    @Email(message = "L'adresse e-mail doit être au format valide")
    @NotEmpty(message = "L'adresse e-mail est obligatoire")
    private String email;

    private String address;

    @Pattern(regexp = "\\d+", message = "Le numéro de téléphone doit contenir uniquement des chiffres")
    @NotEmpty(message = "Le numéro de téléphone est obligatoire")
    private String phone;

    @Pattern(regexp = "\\d+", message = "Le numéro de téléphone doit contenir uniquement des chiffres")
    @NotEmpty(message = "Le numéro d'identité est obligatoire")
    private String nin;

}
