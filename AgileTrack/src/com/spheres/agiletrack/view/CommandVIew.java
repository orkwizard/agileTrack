package com.spheres.agiletrack.view;

import com.spheres.agiletrack.data.JPADataProvider;
import com.spheres.agiletrack.entities.Command;
import com.spheres.agiletrack.entities.Part;
import com.spheres.agiletrack.view.forms.CommandEditorImp;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

public class CommandVIew extends CommandModel implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPADataProvider provider = new JPADataProvider();
	private JPAContainer<Command> commands;
	private JPAContainer<Part> parts;
	private Command commandFilter;
	public static final String VIEW_NAME = "command_view";
	private Window command_window;
	private CommandEditorImp form_editor = new CommandEditorImp();
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/*private void populateCommands(){
		super.cbCommand.setContainerDataSource(commands);
		super.cbCommand.setItemCaptionPropertyId("description");
		super.cbCommand.addValueChangeListener(new ValueChangeListener() {
		private static final long serialVersionUID = 1L;
		@Override
		public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Object id = event.getProperty().getValue();
				FieldFactory fieldFactory = new FieldFactory();
				if(id!=null)
					commandFilter = commands.getItem(id).getEntity();
				populateGrid();
			}
		});
	}*/
	
	private void populateGrid() {
		// TODO Auto-generated method stub
		parts = provider.getParts(commandFilter);
		super.table_parrs.removeAllItems();
		super.table_parrs.refreshRowCache();
		super.table_parrs.setContainerDataSource(parts);
		super.table_parrs.setVisibleColumns("partName","descripción","length");
	}
	
	
	private void populateTree(){
		super.tree_commands.setContainerDataSource(commands);
		super.tree_commands.setItemCaptionPropertyId("description");
		super.tree_commands.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Object id = event.getProperty().getValue();
				FieldFactory fieldFactory = new FieldFactory();
				if(id!=null)
					commandFilter = commands.getItem(id).getEntity();
				populateGrid();
			}
		});
	}
	
	
	 @SuppressWarnings("serial")
	public CommandVIew() {
		// TODO Auto-generated constructor stub
		 commands = provider.getCommands();
		 parts = provider.getParts(null);
		 //populateCommands();	
		 populateTree();
		 
		 
		 super.btPartNew.addClickListener(new ClickListener() {
			
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
		 command_window = new Window("Editor Comandos");
		 command_window.setModal(true);
		 command_window.center();
		 addComponent(command_window);
		 command_window.setVisible(true);
		 //getUI().setContent(command_window);
	
		 //getUI().setParent(command_window);
		 //getUI().addWindow(command_window);
		 
	 }

	 
	 

}
