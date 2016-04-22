package com.spheres.agiletrack.view;

import java.util.Collection;
import java.util.List;

import com.spheres.agiletrack.entities.Command;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.client.ui.VFilterSelect.Select;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class CommandVIew extends CommandModel implements View {

	private JPAContainer<Command> commands;
	private final static String Persistence_UNIT ="AgileTrack";
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void populateCommands(){
		
		commands = JPAContainerFactory.make(Command.class,Persistence_UNIT);
		System.out.println("Contenedor");
		//System.out.println(container.getItemIds().iterator().next().toString());
		super.cbCommand.setContainerDataSource(commands);
		//super.cbCommand.setItemCaptionMode(Select.FIRST);
		super.cbCommand.setItemCaptionPropertyId("description");
		
		
		
		
		super.cbCommand.addValueChangeListener(new ValueChangeListener() {
		
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Item command = commands.getItem(event.getProperty().getValue());
				populateGrid(command);
			}

			
		});
	}
	
	private void populateGrid(Item command) {
		// TODO Auto-generated method stub
		FieldFactory fieldFactory = new FieldFactory();
		//super.table_parrs.setPropertyDataSource(newDataSource);
		//
	}
	
	
	
	 public CommandVIew() {
		// TODO Auto-generated constructor stub
		 populateCommands();
		 
	}


}
