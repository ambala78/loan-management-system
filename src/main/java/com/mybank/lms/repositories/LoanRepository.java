package com.mybank.lms.repositories;

import com.mybank.lms.domain.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {

}