package com.zup.rebeldes.expectionHandler;


import com.zup.rebeldes.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlingOfInvalidArgument(MethodArgumentNotValidException argumentNotValidException){
        ExceptionDTO exceptionResponse = new ExceptionDTO(new Date(),"Dados inserido incorretamente: "+argumentNotValidException.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlingOf404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handlingOfInvalidQuantity(IllegalArgumentException illegalArgumentException){
        ExceptionDTO exceptionDTO = new ExceptionDTO(new Date(),illegalArgumentException.getMessage());
        return ResponseEntity.status(401).body(exceptionDTO);
    }
}