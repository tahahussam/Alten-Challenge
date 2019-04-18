package com.altenchallenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.altenchallenge.entity.Customer;
import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.entity.VehicleStatus;
import com.altenchallenge.exception.NotValidCustomerException;
import com.altenchallenge.exception.NotValidStatusException;
import com.altenchallenge.repository.CustomerRepository;
import com.altenchallenge.repository.VehicleRepository;
import com.altenchallenge.repository.VehicleStatusRepository;
import com.altenchallenge.service.ICommonService;
import com.altenchallenge.service.IVehicleService;

/**
 * @author Taha
 *
 */
@Service
public class VehicleServiceImpl implements IVehicleService, ICommonService {

	private final static Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.altenchallenge.service.IVehicleService#listAllVehicles(int[])
	 */
	@Override
	public List<Vehicle> listAllVehicles(int... pageDetails) throws Exception {
		try {
			Page<Vehicle> carsPage = vehicleRepository.findAll(gotoPage(pageDetails));
			return carsPage.getContent();
		} catch (Exception e) {
			logger.error("Exception in listing All Vehicles: ", e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.altenchallenge.service.IVehicleService#filterVehicleByCustomer(long,
	 * int[])
	 */
	@Override
	public List<Vehicle> filterVehicleByCustomer(long customerId, int... pageDetails) throws Exception {
		try {
			Optional<Customer> customer = customerRepository.findById(customerId);

			if (customer.isPresent()) {
				logger.debug("trying to get Vehicles fot Customer {}", customer.get());
				Page<Vehicle> carsPage = vehicleRepository.findByCustomer(customer.get(), gotoPage(pageDetails));
				return carsPage.getContent();
			}

			throw new NotValidCustomerException("Not Valid Customer Id");
		} catch (Exception e) {
			logger.error("Exception in filterVehicleByCustomer: ", e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.altenchallenge.service.IVehicleService#filterVehicleByStatus(int,
	 * int[])
	 */
	@Override
	public List<Vehicle> filterVehicleByStatus(int status, int... pageDetails) throws Exception {
		try {
			Optional<VehicleStatus> vehicleStatus = vehicleStatusRepository.findById(status);

			if (vehicleStatus.isPresent()) {
				logger.debug("trying to get Vehicles fot status {}", vehicleStatus.get());
				Page<Vehicle> carsPage = vehicleRepository.findByStatus(vehicleStatus.get(), gotoPage(pageDetails));
				return carsPage.getContent();
			}
			throw new NotValidStatusException("Not Valid Status");
		} catch (Exception e) {
			logger.error("Exception in filterVehicleByStatus: ", e);
			throw e;
		}
	}
}