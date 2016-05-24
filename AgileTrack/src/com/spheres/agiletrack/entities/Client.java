package com.spheres.agiletrack.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private int clientId;

	@Column(name="client_login")
	private String clientLogin;

	@Column(name="client_name")
	private String clientName;

	@Column(name="client_password")
	private String clientPassword;

	//bi-directional many-to-one association to Starlink
	@OneToMany(mappedBy="client")
	private List<Starlink> starlinks;

	//bi-directional many-to-one association to Unit
	@OneToMany(mappedBy="client")
	private List<Unit> units;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientLogin() {
		return this.clientLogin;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPassword() {
		return this.clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public List<Starlink> getStarlinks() {
		return this.starlinks;
	}

	public void setStarlinks(List<Starlink> starlinks) {
		this.starlinks = starlinks;
	}

	public Starlink addStarlink(Starlink starlink) {
		getStarlinks().add(starlink);
		starlink.setClient(this);

		return starlink;
	}

	public Starlink removeStarlink(Starlink starlink) {
		getStarlinks().remove(starlink);
		starlink.setClient(null);

		return starlink;
	}

	public List<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setClient(this);

		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setClient(null);

		return unit;
	}

}