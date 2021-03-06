package com.altenchallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Taha
 *
 */
@Entity
public class Customer {

	@Id
	private Long id;

	private String name;

	private String address;

//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//	private Set<Vehicle> vehicles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Set<Vehicle> getVehicles() {
//		return vehicles;
//	}
//
//	public void setVehicles(Set<Vehicle> vehicles) {
//		this.vehicles = vehicles;
//	}

}
