package com.ecpi.votify.models.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String nin;
}
