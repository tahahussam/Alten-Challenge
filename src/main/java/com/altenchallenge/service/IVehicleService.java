package com.altenchallenge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.exception.NotValidStatusException;

/**
 * @author Taha this is Vehicle interface
 */
@Service
public interface IVehicleService {

	/**
	 * @param pageDetails page number then page size
	 * @return all Vehicles List
	 * @throws Exception
	 */
	List<Vehicle> listAllVehicles(int... pageDetails) throws Exception;

	/**
	 * @param customerId
	 * @param pageDetails page number then page size
	 * @return Vehicles List for given customer
	 * @throws Exception NotValidCustomerException is customer id is not correct
	 */
	List<Vehicle> filterVehicleByCustomer(long customerId, int... pageDetails) throws Exception;

	/**
	 * @param status
	 * @param pageDetails page number then page size
	 * @return Vehicles List for given status
	 * @throws NotValidStatusException if status is not valid
	 */
	List<Vehicle> filterVehicleByStatus(int status, int... pageDetails) throws Exception;

}