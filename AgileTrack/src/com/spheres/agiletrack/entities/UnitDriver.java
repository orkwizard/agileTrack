package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UNIT_DRIVERS database table.
 * 
 */
@Entity
@Table(name="UNIT_DRIVERS")
@NamedQuery(name="UnitDriver.findAll", query="SELECT u FROM UnitDriver u")
public class UnitDriver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="driver_id")
	private int driverId;

	@Column(name="unit_id")
	private int unitId;

	public UnitDriver() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDriverId() {
		return this.driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getUnitId() {
		return this.unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

}