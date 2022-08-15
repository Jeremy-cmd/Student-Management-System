package com.example.studentrecords.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLDataException;
import java.sql.SQLException;

@ControllerAdvice
@RestController
public class StudentRecordsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity<Error> handleSqlException(
            EmptyResultDataAccessException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage("Could not retrieve data");
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public final ResponseEntity<Error> sqlAccessException() {

        Error err = new Error();
        err.setMessage("Could not access data");
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
