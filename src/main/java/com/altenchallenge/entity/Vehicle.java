package com.altenchallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Taha
 *
 */
@Entity
public class Vehicle {
	@Id
	private String vehicleId;

	private String regNo;

	@ManyToOne(targetEntity=Customer.class)
	private Customer customer;	
	
	@ManyToOne(targetEntity=Vehiclestatus.class)
	private Vehiclestatus status;


	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Vehiclestatus getStatus() {
		return status;
	}

	public void setStatus(Vehiclestatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
