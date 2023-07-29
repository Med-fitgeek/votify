package com.ecpi.votify.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiError {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
    private List<String> validationErrors;
}


