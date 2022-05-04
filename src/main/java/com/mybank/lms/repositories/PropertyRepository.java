package com.mybank.lms.repositories;

import com.mybank.lms.domain.Property;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, Long> {

}