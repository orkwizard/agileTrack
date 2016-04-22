package com.spheres.agiletrack.view;

import java.util.Collection;
import java.util.List;

import com.spheres.agiletrack.entities.Command;
import com.spheres.agiletrack.entities.Part;
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
import com.vaadin.ui.Table;

public class CommandVIew extends CommandModel implements View {

	private JPAContainer<Command> commands;
	private JPAContainer<Part> parts;
	private final static String Persistence_UNIT ="Agile";
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void populateCommands(){
		
		commands = JPAContainerFactory.make(Command.class,Persistence_UNIT);
		System.out.println("Contenedor");
		super.cbCommand.setContainerDataSource(commands);
		super.cbCommand.setItemCaptionPropertyId("description");
		
		
		
		
		super.cbCommand.addValueChangeListener(new ValueChangeListener() {
		
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Item command = commands.getItem(event.getProperty().getValue());
				int size = command.getItemPropertyIds().size();
				System.out.println("Elementos??:---->" + size);
				populateGrid(command);
			}

			
		});
	}
	
	private void populateGrid(Item command) {
		// TODO Auto-generated method stub
		//parts = JPAContainerFactory.make(Part.class, Persistence_UNIT);
		parts = JPAContainerFactory.makeReadOnly(Part.class,Persistence_UNIT);
		
		//super.table_parrs.removeAllItems();
		//
		//System.out.println(command.toString());
		//parts.addContainerFilter(new Equal("command",) );
		
		
		super.table_parrs.setContainerDataSource(parts);
		super.table_parrs.setVisibleColumns("partName","descripción","length");
	}
	
	
	
	 public CommandVIew() {
		// TODO Auto-generated constructor stub
		 populateCommands();
		 
	}


}
