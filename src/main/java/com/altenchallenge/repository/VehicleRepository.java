package com.altenchallenge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.altenchallenge.entity.Customer;
import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.entity.Vehiclestatus;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called VehicleRepository CRUD
 * refers Create, Read, Update, Delete
 * 
 * @author Taha
 */
@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, String> {

	Page<Vehicle> findByCustomer(Customer customer, Pageable page);

	Page<Vehicle> findByStatus(Vehiclestatus status, Pageable page);

}