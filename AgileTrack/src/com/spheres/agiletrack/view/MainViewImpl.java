package com.spheres.agiletrack.view;


import com.spheres.agiletrack.app.Dashboard;
import com.spheres.agiletrack.app.DashboardImp;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.UI;

public class MainViewImpl extends MainView implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "main";
	Navigator nav;
	
	public MainViewImpl(){
		super();
		nav = new Navigator(UI.getCurrent(),scroll_panel);
		//nav.addView(VIEW_NAME, MainViewImpl.class);
		nav.addView(CommandVIew.VIEW_NAME, CommandVIew.class);
		nav.addView(DashboardImp.VIEW_NAME, DashboardImp.class);
		if(nav.getState().isEmpty()){
			nav.navigateTo(DashboardImp.VIEW_NAME);
		}
	}

	
	
	
	/*
	public void navAdd(){
		nav.addView("command",CommandVIew.class);
		nav.addView("main", this.getClass());
		if(nav.getState().isEmpty()){
			
		}
	}*/
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
