package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MESSAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private int messageId;

	private byte checksum;

	private int command;

	@Column(name="message_header")
	private String messageHeader;

	@Column(name="protocol_footer")
	private int protocolFooter;

	@Column(name="protocol_header")
	private String protocolHeader;

	private int reference;

	@Column(name="unit_id")
	private String unitId;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public byte getChecksum() {
		return this.checksum;
	}

	public void setChecksum(byte checksum) {
		this.checksum = checksum;
	}

	public int getCommand() {
		return this.command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public String getMessageHeader() {
		return this.messageHeader;
	}

	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}

	public int getProtocolFooter() {
		return this.protocolFooter;
	}

	public void setProtocolFooter(int protocolFooter) {
		this.protocolFooter = protocolFooter;
	}

	public String getProtocolHeader() {
		return this.protocolHeader;
	}

	public void setProtocolHeader(String protocolHeader) {
		this.protocolHeader = protocolHeader;
	}

	public int getReference() {
		return this.reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

}