package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STARLINK database table.
 * 
 */
@Entity
@NamedQuery(name="Starlink.findAll", query="SELECT s FROM Starlink s")
public class Starlink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="starlink_id")
	private int starlinkId;

	private String name;

	private String uid;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	public Starlink() {
	}

	public int getStarlinkId() {
		return this.starlinkId;
	}

	public void setStarlinkId(int starlinkId) {
		this.starlinkId = starlinkId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}