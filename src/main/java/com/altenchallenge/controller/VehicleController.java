package com.altenchallenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.exception.NotValidCustomerException;
import com.altenchallenge.exception.NotValidStatusException;
import com.altenchallenge.service.IVehicleService;

/**
 * @author Taha
 *
 */
@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;

	@GetMapping(path = { "/all", "/all/{pageNumber:[1-9][\\d]*}",
			"/all/{pageNumber:[1-9][\\d]*}/{pageSize:[1-9][\\d]*}" })
	public ResponseEntity<?> getAllVehicles(
			@PathVariable(value = "pageNumber", required = false) Optional<Integer> pageNumber,
			@PathVariable(value = "pageSize", required = false) Optional<Integer> pageSize) {

		try {
			List<Vehicle> carsList;

			if (pageNumber.isPresent() && pageSize.isPresent())
				carsList = vehicleService.listAllVehicles(pageNumber.get(), pageSize.get());
			else if (pageNumber.isPresent())
				carsList = vehicleService.listAllVehicles(pageNumber.get());
			else
				carsList = vehicleService.listAllVehicles();

			return new ResponseEntity<>(carsList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = { "/customer/{customerId:[1-9][\\d]*}",
			"/customer/{customerId:[1-9][\\d]*}/{pageNumber:[1-9][\\d]*}",
			"/customer/{customerId:[1-9][\\d]*}/{pageNumber:[1-9][\\d]*}/{pageSize:[1-9][\\d]*}" })
	public ResponseEntity<?> getVehiclesForCustomer(
			@PathVariable(value = "customerId", required = true) Long customerId,
			@PathVariable(value = "pageNumber", required = false) Optional<Integer> pageNumber,
			@PathVariable(value = "pageSize", required = false) Optional<Integer> pageSize) {

		try {
			List<Vehicle> carsList;

			if (pageNumber.isPresent() && pageSize.isPresent())
				carsList = vehicleService.filterVehicleByCustomer(customerId, pageNumber.get(), pageSize.get());
			else if (pageNumber.isPresent())
				carsList = vehicleService.filterVehicleByCustomer(customerId, pageNumber.get());
			else
				carsList = vehicleService.filterVehicleByCustomer(customerId);

			return new ResponseEntity<>(carsList, HttpStatus.OK);
		} catch (NotValidCustomerException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = { "/status/{status:[1-9][\\d]*}", "/status/{status:[1-9][\\d]*}/{pageNumber:[1-9][\\d]*}",
			"/status/{status:[1-9][\\d]*}/{pageNumber:[1-9][\\d]*}/{pageSize:[1-9][\\d]*}" })
	public ResponseEntity<?> getVehiclesForStatus(@PathVariable(value = "status", required = true) int status,
			@PathVariable(value = "pageNumber", required = false) Optional<Integer> pageNumber,
			@PathVariable(value = "pageSize", required = false) Optional<Integer> pageSize) {

		try {
			List<Vehicle> carsList;

			if (pageNumber.isPresent() && pageSize.isPresent())
				carsList = vehicleService.filterVehicleByStatus(status, pageNumber.get(), pageSize.get());
			else if (pageNumber.isPresent())
				carsList = vehicleService.filterVehicleByStatus(status, pageNumber.get());
			else
				carsList = vehicleService.filterVehicleByStatus(status);

			return new ResponseEntity<>(carsList, HttpStatus.OK);
		} catch (NotValidStatusException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}