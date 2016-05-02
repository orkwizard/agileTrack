package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PART database table.
 * 
 */
@Entity
@NamedQuery(name="Part.findAll", query="SELECT p FROM Part p")
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="part_id")
	private int partId;

	private String descripción;

	private short length;

	@Column(name="part_name")
	private String partName;

	//bi-directional many-to-one association to Command
	@ManyToOne
	@JoinColumn(name="command_id")
	private Command command;

	public Part() {
	}

	public int getPartId() {
		return this.partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getDescripción() {
		return this.descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public short getLength() {
		return this.length;
	}

	public void setLength(short length) {
		this.length = length;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Command getCommand() {
		return this.command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

}