package com.mybank.lms.repositories;

import com.mybank.lms.domain.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@PreAuthorize("hasRole('ADMIN')")
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long>, QueryByExampleExecutor<Loan> {
}