package com.spheres.agiletrack.view;

import com.spheres.agiletrack.entities.Command;
import com.spheres.agiletrack.entities.Part;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class CommandVIew extends CommandModel implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPAContainer<Command> commands;
	private JPAContainer<Part> parts;
	private final static String Persistence_UNIT ="Agile";
	private Command commandFilter;
	public static final String VIEW_NAME = "command_view";
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void populateCommands(){
		super.cbCommand.setContainerDataSource(commands);
		super.cbCommand.setItemCaptionPropertyId("description");
		super.cbCommand.addValueChangeListener(new ValueChangeListener() {
		private static final long serialVersionUID = 1L;
		@Override
		public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Object id = event.getProperty().getValue();
				if(id!=null)
					commandFilter = commands.getItem(id).getEntity();
				populateGrid();
			}
		});
	}
	
	private void populateGrid() {
		// TODO Auto-generated method stub
		if(commandFilter!=null){
			parts.setApplyFiltersImmediately(false);
			parts.removeAllContainerFilters();
			super.table_parrs.setContainerDataSource(parts);
			parts.addContainerFilter(new Equal("command",commandFilter));
			parts.applyFilters();
			super.table_parrs.setVisibleColumns("partName","descripción","length");
		}else{
			super.table_parrs.removeAllItems();
			super.table_parrs.refreshRowCache();
		}
	}
	
	
	
	 @SuppressWarnings("serial")
	public CommandVIew() {
		// TODO Auto-generated constructor stub
		 commands = JPAContainerFactory.make(Command.class,Persistence_UNIT);
		 parts = JPAContainerFactory.make(Part.class,Persistence_UNIT);
		 populateCommands();		 
		 super.btNew.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Boton Add Part");
			}
		});
		 
		super.btAddCommand.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Boton Add Command");
				addNewCommand();
			}
		}); 
		
		super.btDelete.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Boton Delet Part");
			}
		});
		 
		 
	}

	 private void addNewCommand(){
		 
		 
	 }

	 
	 

}
