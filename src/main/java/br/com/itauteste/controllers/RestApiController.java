package br.com.itauteste.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface RestApiController {

    default <T> ResponseEntity<T> buildReturn(T entity, HttpHeaders headers, HttpStatus httpStatus) {
        return new ResponseEntity(entity, headers, httpStatus);
    }

    default <T> ResponseEntity<T> returnOk(T entity) {
        return this.buildReturn(entity, null, HttpStatus.OK);
    }
}
