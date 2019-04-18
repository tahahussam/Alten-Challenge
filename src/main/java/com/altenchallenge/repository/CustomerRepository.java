package com.altenchallenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.altenchallenge.entity.Customer;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
 * CRUD refers Create, Read, Update, Delete
 * 
 * @author Taha
 */
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}