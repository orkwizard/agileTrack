package com.spheres.agiletrack.model;

import java.util.List;

import com.spheres.agiletrack.entities.Command;

public interface CommandModel {
	public List<Command> getCommands();
	public void addCommand(Command command);
	public void deleteCommand(Command command);
	
}
