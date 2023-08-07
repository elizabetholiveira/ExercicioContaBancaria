//package com.exercicio.contaBancaria.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@org.springframework.web.bind.annotation.ControllerAdvice
//public class ControllerAdvice {
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<String> handleInternalServerError(Exception e){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deu erro interno no servidor!" + " ( " + e.getMessage() + " ) ");
//    }
//}
