package com.spheres.agiletrack.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMMAND database table.
 * 
 */
@Entity
@NamedQuery(name="Command.findAll", query="SELECT c FROM Command c")
public class Command implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="command_id")
	private int commandId;

	private String command;

	private String description;

	@Column(name="is_server")
	private boolean isServer;

	@Column(name="is_slu")
	private boolean isSlu;

	//bi-directional many-to-one association to Part
	@OneToMany(mappedBy="command")
	private List<Part> parts;

	public Command() {
	}

	public int getCommandId() {
		return this.commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsServer() {
		return this.isServer;
	}

	public void setIsServer(boolean isServer) {
		this.isServer = isServer;
	}

	public boolean getIsSlu() {
		return this.isSlu;
	}

	public void setIsSlu(boolean isSlu) {
		this.isSlu = isSlu;
	}

	public List<Part> getParts() {
		return this.parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public Part addPart(Part part) {
		getParts().add(part);
		part.setCommand(this);

		return part;
	}

	public Part removePart(Part part) {
		getParts().remove(part);
		part.setCommand(null);

		return part;
	}

}