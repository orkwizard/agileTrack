package com.spheres.agiletrack.view.forms;

import com.spheres.agiletrack.view.CommandVIew;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class ConfigurationTabsViewImp extends ConfigurationTabsView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "configuration";
	public ConfigurationTabsViewImp(){
		super();
		init();
	}
	
	private void init(){
		String[] tabs = {"Comandos","Unidades",""};
		tabsheet.setVisible(true);
		tabsheet.setResponsive(true);
		CommandVIew view = new CommandVIew();
		tabsheet.addTab(view).setCaption("Comandos");;
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
