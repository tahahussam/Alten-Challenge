package com.altenchallenge.service.impl;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.entity.Vehiclestatus;
import com.altenchallenge.repository.VehicleRepository;
import com.altenchallenge.repository.VehicleStatusRepository;

@Service
@EnableAsync
@EnableScheduling
public class RandomSimulationVehiclesStatusScheduler {

	private final static Logger logger = LoggerFactory.getLogger(RandomSimulationVehiclesStatusScheduler.class);

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	/**
	 * sendRandomVehiclesStatus every one minute to send random status for all
	 * vehicles
	 */
	@Scheduled(fixedRate = 1000 * 60) // one minute
	public void sendRandomVehiclesStatus() {
		logger.info("--------- Start sendRandomVehiclesStatus ---------");
		Iterable<Vehicle> allVehicles = vehicleRepository.findAll();

		for (Vehicle vehicle : allVehicles) {
			vehicle.setStatus(getRandomStatus());
		}

		logger.info("--------- End sendRandomVehiclesStatus ---------");
	}

	private Vehiclestatus getRandomStatus() {
		Random rand = new Random();

		Optional<Vehiclestatus> vehicleStatus = vehicleStatusRepository.findById(rand.nextInt(2) + 1);

		if (vehicleStatus.isPresent())
			return vehicleStatus.get();
		return null;
	}

}