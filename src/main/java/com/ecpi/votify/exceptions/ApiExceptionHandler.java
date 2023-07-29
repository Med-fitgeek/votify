package com.ecpi.votify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestExcpetion(ApiRequestException e) {
        // 1. Create payload containing excpetion details
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return reponse entity
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> validationErrors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            validationErrors.add(fieldError.getDefaultMessage());
        }

        // Créer un objet contenant les détails de l'erreur de validation
        ApiError apiError = new ApiError("Erreur de validation", HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));

        // Ajouter les messages d'erreur de validation à la réponse
        apiError.setValidationErrors(validationErrors);

        // Renvoyer la réponse avec le statut HTTP "BAD_REQUEST" (400)
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}


