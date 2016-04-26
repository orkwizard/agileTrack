package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="starlink_id")
	private int starlinkId;

	@Column(name="client_login")
	private String clientLogin;

	@Column(name="client_name")
	private String clientName;

	@Column(name="client_password")
	private String clientPassword;

	public Client() {
	}

	public int getStarlinkId() {
		return this.starlinkId;
	}

	public void setStarlinkId(int starlinkId) {
		this.starlinkId = starlinkId;
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

}