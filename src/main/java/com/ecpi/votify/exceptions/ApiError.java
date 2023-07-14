package com.ecpi.votify.exceptions;

import org.springframework.http.HttpStatus;

// Classe interne pour représenter la structure d'erreur JSON
public class ApiError {
    private HttpStatus status;
    private String message;


    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;

    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}