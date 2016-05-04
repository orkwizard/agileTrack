package com.spheres.agiletrack.forms;

import com.spheres.agiletrack.entities.Command;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class MDCommandParts extends CustomComponent{

	String context;
	private final static String Persistence_UNIT ="Agile";
	
	public void init(String context){
		VerticalLayout layout = new VerticalLayout();
		if("masterdetail".equals(context))
			masterdetail(layout);
		
		setCompositionRoot(layout);
	}
	
	
	private void masterdetail(Layout layout){
		
		final JPAContainer<Command> commands = JPAContainerFactory.make(Command.class, Persistence_UNIT);
		final FieldFactory fieldFactory = new FieldFactory();
		
		Panel masterPanel = new Panel("Master Table");
		Table masterTable = new Table("Seleccionar un Comando :",commands);
		masterTable.setVisibleColumns(new String[]{"command"});
		masterPanel.addComponent(masterTable);
		
		
	}
}
