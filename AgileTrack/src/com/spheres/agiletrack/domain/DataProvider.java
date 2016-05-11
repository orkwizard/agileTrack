package com.spheres.agiletrack.domain;

import java.util.List;

import com.spheres.agiletrack.entities.Client;
import com.spheres.agiletrack.entities.Command;
import com.spheres.agiletrack.entities.Part;
import com.vaadin.addon.jpacontainer.JPAContainer;

public interface DataProvider {
	 
	 final static String Persistence_UNIT ="Agile";
	
	 Client authenticate(String userName, String password);
	 JPAContainer<Command> getCommands();
	 JPAContainer<Part> getParts(Command filter);
	 
}
