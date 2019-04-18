package com.altenchallenge.service.impl;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@EnableScheduling
public class DisconnectedVehiclesScheduler {

	private final static Logger logger = LoggerFactory.getLogger(DisconnectedVehiclesScheduler.class);

	/**
	 * checkVehicles every one minute to check all vehicles
	 */
	@Scheduled(fixedRate = 1000 * 60)
	public void checkVehicles() {
		logger.info("--------- Start checkVehicles ---------");
		LocalTime timeBeforeMinute = LocalTime.now().minusMinutes(1);

		
		
		logger.info("--------- End checkVehicles ---------");
	}

}