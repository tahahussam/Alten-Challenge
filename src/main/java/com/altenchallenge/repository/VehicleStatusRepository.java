package com.altenchallenge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.altenchallenge.entity.VehicleStatus;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called
 * VehicleStatusRepository CRUD refers Create, Read, Update, Delete
 * 
 * @author Taha
 */
@Repository
public interface VehicleStatusRepository extends PagingAndSortingRepository<VehicleStatus, Integer> {

}