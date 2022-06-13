package org.fasttrackit.curs6.persons.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    ApiError handleResourceNotFound(ResourceNotFoundException ex) {
        return new ApiError("RNF01", ex.getMessage());
    }

    @ExceptionHandler(InvalidPersonException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleResourceNotFound(InvalidPersonException ex) {
        return new ApiError("INV01", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ApiError handleAllExceptions(Exception ex) {
        log.error("Generic error", ex);
        return new ApiError("GENERIC", "Internal error ocured. Please check logs");
    }
}

record ApiError(String code, String message) {
}
