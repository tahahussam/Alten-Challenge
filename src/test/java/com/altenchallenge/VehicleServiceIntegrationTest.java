package com.altenchallenge;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.altenchallenge.service.ICommonService;

@AutoConfigureMockMvc
@SpringBootTest
public class VehicleServiceIntegrationTest extends AbstractTransactionalTestNGSpringContextTests
		implements ICommonService {

	@Autowired
	private MockMvc mockMvc;

	@BeforeMethod
	public void setup() {

	}

	@AfterMethod
	public void tearDown() {

	}

	@Test
	public void testGettingAllVehicles() throws Exception {
		mockMvc.perform(get("/vehicles/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].vehicleId", is("YS2R4X20005399401")));
	}

	@Test
	public void testFilteringVehiclesByCustomerValid() throws Exception {
		mockMvc.perform(get("/vehicles/customer/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].vehicleId", is("YS2R4X20005399401")));
	}

	@Test
	public void testFilteringVehiclesByCustomerNotValid() throws Exception {
		mockMvc.perform(get("/vehicles/customer/5555").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testFilteringVehiclesByStatusValid() throws Exception {
		mockMvc.perform(get("/vehicles/status/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testFilteringVehiclesByStatusNotValid() throws Exception {
		mockMvc.perform(get("/vehicles/status/5555").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

}