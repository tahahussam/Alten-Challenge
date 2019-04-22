package com.altenchallenge;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.altenchallenge.entity.Vehicle;
import com.altenchallenge.service.ICommonService;
import com.altenchallenge.service.IVehicleService;

@SpringBootTest
public class VehicleServiceTest extends AbstractTransactionalTestNGSpringContextTests implements ICommonService {

	@Autowired
	private IVehicleService vehicleService;

	@BeforeMethod
	public void setup() {

	}

	@AfterMethod
	public void tearDown() {

	}

	@Test
	public void testGetAllVehicles() throws Exception {
		List<Vehicle> vehiclesList = vehicleService.listAllVehicles();
		assertNotNull(vehiclesList);
		assertEquals(7, vehiclesList.size());
	}

	@Test
	public void testGetAllCarsWithPageNumber() throws Exception {
		List<Vehicle> vehiclesList = vehicleService.listAllVehicles(1);
		assertNotNull(vehiclesList);
		assertEquals(7, vehiclesList.size());
	}

	@Test
	public void testGetAllCarsWithPageNumberAndPageSize() throws Exception {
		List<Vehicle> vehiclesList = vehicleService.listAllVehicles(1, 1);
		assertNotNull(vehiclesList);
		assertEquals(1, vehiclesList.size());

		vehiclesList = vehicleService.listAllVehicles(2, 2);
		assertNotNull(vehiclesList);
		assertEquals(2, vehiclesList.size());

	}
}