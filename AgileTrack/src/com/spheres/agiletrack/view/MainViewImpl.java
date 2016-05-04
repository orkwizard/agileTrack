package com.spheres.agiletrack.view;


import java.util.Iterator;

import com.spheres.agiletrack.app.DashboardImp;
import com.spheres.agiletrack.entities.Client;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class MainViewImpl extends MainView implements ViewDisplay{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String STYLE_SELECTED = "selected";
	public static final String VIEW_NAME = "main";
	private Navigator nav;
	
	
	public MainViewImpl(){
		super();
		nav = new Navigator(UI.getCurrent(),(ViewDisplay) this);
		//nav.addView(VIEW_NAME, MainViewImpl.class);
		user_name_label.setValue(getCurrentUser());
		
		addNavigatorView(CommandVIew.VIEW_NAME, CommandVIew.class,btConfig);
		addNavigatorView(DashboardImp.VIEW_NAME, DashboardImp.class,btDashboard);
		
		if(nav.getState().isEmpty()){
			nav.navigateTo(DashboardImp.VIEW_NAME);
		}
		else {
            nav.navigateTo(nav.getState());
        }
		
		
		//btConfig.addClickListener(event -> 	doNavigate(CommandVIew.VIEW_NAME));
		//btDashboard.addClickListener(event-> doNavigate(DashboardImp.VIEW_NAME));
	}
	
	
	

	private void addNavigatorView(String viewName,Class<? extends View> viewClass, Button menuButton) {
        nav.addView(viewName, viewClass);
        menuButton.addClickListener(event -> doNavigate(viewName));
        menuButton.setData(viewClass.getName());
    }
	
	
	private void doNavigate(String viewName) {
		UI.getCurrent().getNavigator().navigateTo(viewName);
		
		
	}


	 private String getCurrentUser() {
	        return (String) VaadinSession.getCurrent().getAttribute(
	                "UserName");
	    }


	@Override
    public void showView(View view) {
        if (view instanceof Component) {
            scroll_panel.setContent((Component) view);
            Iterator<Component> it = side_bar.iterator();
            while (it.hasNext()) {
                adjustStyleByData(it.next(), view.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("View is not a Component");
        }
    }
	
	

	private void adjustStyleByData(Object component, Object data) {
	        if (component instanceof Button) {
	            if (data != null && data.equals(((Button) component).getData())) {
	                ((Button) component).addStyleName(STYLE_SELECTED);
	            } else {
	            	((Button) component).removeStyleName(STYLE_SELECTED);
	            }
	        }
	    }

}
