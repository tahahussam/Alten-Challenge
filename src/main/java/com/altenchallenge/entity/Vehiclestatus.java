package com.altenchallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Taha
 *
 */
@Entity
public class Vehiclestatus {

	@Id
	private Integer id;

	private String statusType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

}