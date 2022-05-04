package com.mybank.lms.repositories;

import com.mybank.lms.domain.LmsUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsUserRepository extends PagingAndSortingRepository<LmsUser, String>{

}