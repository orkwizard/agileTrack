package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="commandId")
	private int commandId;

	@Column(name="message_header")
	private String messageHeader;

	@Column(name="protocol_header")
	private String protocolHeader;

	@Column(name="unit_id")
	private String unitId;

	//bi-directional many-to-one association to Data
	@OneToMany(mappedBy="message")
	private List<Data> data;

	public Message() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommandId() {
		return this.commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public String getMessageHeader() {
		return this.messageHeader;
	}

	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}

	public String getProtocolHeader() {
		return this.protocolHeader;
	}

	public void setProtocolHeader(String protocolHeader) {
		this.protocolHeader = protocolHeader;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public List<Data> getData() {
		return this.data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public Data addData(Data data) {
		getData().add(data);
		data.setMessage(this);

		return data;
	}

	public Data removeData(Data data) {
		getData().remove(data);
		data.setMessage(null);

		return data;
	}

}