package com.mybank.lms.service;

import com.mybank.lms.domain.Borrower;
import com.mybank.lms.domain.Loan;
import com.mybank.lms.exception.LoanNotFoundException;
import com.mybank.lms.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class LmsLoanService {

    @Autowired
    LoanRepository loanRepository;

    public Loan saveLoan(@RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan searchBy(Optional<String> loanNumber, Optional<String> borrowerFirstName, Optional<String> borrowerLastName) {
        Loan loan = Loan.builder().build();
        if (loanNumber.isPresent()) {
            loan.setNumber(loanNumber.get());
        }
        Borrower borrower = Borrower.builder().build();
        if (borrowerFirstName.isPresent()) {
            borrower.setFirstName(borrowerFirstName.get());
            loan.setBorrower(borrower);
        }
        if (borrowerLastName.isPresent()) {
            borrower.setLastName(borrowerLastName.get());
            loan.setBorrower(borrower);
        }

        Optional<Loan> loanOptional = loanRepository.findOne(Example.of(loan));

        if (!loanOptional.isPresent()) {
            throw new LoanNotFoundException();
        } else {
            return loanOptional.get();
        }
    }

}
