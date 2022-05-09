package com.mybank.lms.controller;

import com.mybank.lms.common.Error;
import com.mybank.lms.exception.LmsMissingParameterException;
import com.mybank.lms.exception.LoanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NonUniqueResultException;

@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleMoreLoansException(NonUniqueResultException nonUniqueResultException) {
        Error error = Error.builder()
            .statusCode("ERRBNS100")
            .statusDescription("Found more than one loan for the search criteria.")
            .build();
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleLoanNotFoundException(LoanNotFoundException loanNotFoundException) {
        Error error = Error.builder()
            .statusCode("INFBNS101")
            .statusDescription("Loan Not Found for the search criteria.")
            .build();
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleLmsMissingParameterException(LmsMissingParameterException loanNotFoundException) {
        Error error = Error.builder()
            .statusCode("ERRBNS102")
            .statusDescription("Missing parameter: At least one of loan number, borrower first or last name required.")
            .build();
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
