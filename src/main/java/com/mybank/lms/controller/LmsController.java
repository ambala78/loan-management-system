package com.mybank.lms.controller;

import com.mybank.lms.domain.LmsUser;
import com.mybank.lms.domain.Loan;
import com.mybank.lms.exception.LmsMissingParameterException;
import com.mybank.lms.service.LmsLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LmsController {

    @Autowired
    LmsLoanService lmsLoanService;

    @PostMapping(path = "/saveLoan",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan saveLoan(@RequestBody Loan loan) {
        return lmsLoanService.saveLoan(loan);
    }

    @GetMapping(path = "/searchLoan",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan searchLoan(@RequestParam Optional<String> loanNumber,
                           @RequestParam Optional<String> firstName,
                           @RequestParam Optional<String> lastName) {
        if (!loanNumber.isPresent() && !firstName.isPresent() && !lastName.isPresent()) {
            throw new LmsMissingParameterException();
        } else {
            return lmsLoanService.searchBy(loanNumber, firstName, lastName);
        }
    }

    @GetMapping(path = "/getLoan",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan getLoanById(@RequestParam Optional<Long> loanId) {
        if (!loanId.isPresent()) {
            throw new LmsMissingParameterException();
        } else {
            return lmsLoanService.getLoanById(loanId.get());
        }
    }

    @GetMapping(path = "/user",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public LmsUser authenticateUser(@AuthenticationPrincipal LmsUser lmsUser) {
        return lmsUser;
    }
}
