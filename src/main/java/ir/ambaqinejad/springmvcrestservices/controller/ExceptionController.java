package ir.ambaqinejad.springmvcrestservices.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
