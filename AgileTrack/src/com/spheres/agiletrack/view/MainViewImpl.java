package com.spheres.agiletrack.view;


import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.declarative.Design;

public class MainViewImpl extends MainView implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "main";
	
	public MainViewImpl(){
		Design.read(this);
		Navigator nav = new Navigator(UI.getCurrent(),super.scroll_panel);
		nav.addView(MainViewImpl.VIEW_NAME, MainViewImpl.class);
		if(nav.getState().isEmpty()){
			nav.navigateTo(this.VIEW_NAME);
		}
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
