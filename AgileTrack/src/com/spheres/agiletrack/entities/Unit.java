package com.spheres.agiletrack.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the UNIT database table.
 * 
 */
@Entity
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="unit_id")
	private int unitId;

	private String alias;

	private int celular;

	private String engine;

	private int image;

	private String input1;

	private String input2;

	private String input3;

	private String input4;

	@Temporal(TemporalType.DATE)
	@Column(name="install_date")
	private Date installDate;

	@Column(name="installer_id")
	private int installerId;

	@Column(name="label_id")
	private int labelId;

	private String model;

	private String name;

	private String notes;

	private int nuid;

	private String output1;

	private String output2;

	private String output3;

	private String output4;

	private String output5;

	@Column(name="starlink_id")
	private int starlinkId;

	private int year;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	public Unit() {
	}

	public int getUnitId() {
		return this.unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEngine() {
		return this.engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getImage() {
		return this.image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getInput1() {
		return this.input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getInput2() {
		return this.input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public String getInput3() {
		return this.input3;
	}

	public void setInput3(String input3) {
		this.input3 = input3;
	}

	public String getInput4() {
		return this.input4;
	}

	public void setInput4(String input4) {
		this.input4 = input4;
	}

	public Date getInstallDate() {
		return this.installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public int getInstallerId() {
		return this.installerId;
	}

	public void setInstallerId(int installerId) {
		this.installerId = installerId;
	}

	public int getLabelId() {
		return this.labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getNuid() {
		return this.nuid;
	}

	public void setNuid(int nuid) {
		this.nuid = nuid;
	}

	public String getOutput1() {
		return this.output1;
	}

	public void setOutput1(String output1) {
		this.output1 = output1;
	}

	public String getOutput2() {
		return this.output2;
	}

	public void setOutput2(String output2) {
		this.output2 = output2;
	}

	public String getOutput3() {
		return this.output3;
	}

	public void setOutput3(String output3) {
		this.output3 = output3;
	}

	public String getOutput4() {
		return this.output4;
	}

	public void setOutput4(String output4) {
		this.output4 = output4;
	}

	public String getOutput5() {
		return this.output5;
	}

	public void setOutput5(String output5) {
		this.output5 = output5;
	}

	public int getStarlinkId() {
		return this.starlinkId;
	}

	public void setStarlinkId(int starlinkId) {
		this.starlinkId = starlinkId;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}