package com.mybank.lms.repositories;

import com.mybank.lms.domain.LmsUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@PreAuthorize("hasRole('ADMIN')")
public interface LmsUserRepository extends PagingAndSortingRepository<LmsUser, String> {
}