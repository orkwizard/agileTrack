package com.spheres.agiletrack.view;


import java.util.Iterator;

import com.google.common.eventbus.Subscribe;
import com.spheres.agiletrack.app.DashboardImp;
import com.spheres.agiletrack.entities.Client;
import com.spheres.agiletrack.event.AgileEvent;
import com.spheres.agiletrack.event.AgileEventBus;
import com.spheres.agiletrack.view.forms.ConfigurationTabsViewImp;
import com.vaadin.demo.dashboard.event.DashboardEvent.UserLoggedOutEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;

public class MainViewImpl extends MainView implements ViewDisplay{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String STYLE_SELECTED = "selected";
	public static final String VIEW_NAME = "main";
	private Navigator nav;
	private MenuItem settingsItem;
	final private Client user;
	
	public MainViewImpl(){
		super();
		nav = new Navigator(UI.getCurrent(),(ViewDisplay) this);
		user = getCurrentUser();
		addNavigatorView(ConfigurationTabsViewImp.VIEW_NAME,ConfigurationTabsViewImp.class,btConfig);
		addNavigatorView(DashboardImp.VIEW_NAME, DashboardImp.class,btDashboard);
		buildMenuBar();
		if(nav.getState().isEmpty()){
			nav.navigateTo(DashboardImp.VIEW_NAME);
		}
		else {
            nav.navigateTo(nav.getState());
        }
	}
	
	
	@Subscribe
    public void userLoggedOut() {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }
	

	private void buildMenuBar() {
		// TODO Auto-generated method stub
	
		menuBar.setCaption("");
		menuBar.addStyleName("user-menu");
		menuBar.addItem("", new ThemeResource(
                "img/profile-pic-300px.jpg"), null);
		//menuBar.setCaption(user.getClientName());
		menuBar.addItem("Editar Perfil", new Command(){
			@Override
			public void menuSelected(MenuItem selectedItem) {
				// TODO Auto-generated method stub
				System.out.println("Click Editar Perfil");
			}
		});
		 
	    menuBar.addItem("Log Out", new Command() {
	         @Override
	         public void menuSelected(final MenuItem selectedItem) {
	        	 	AgileEventBus.post(new UserLoggedOutEvent());
	                //DashboardEventBus.post(new UserLoggedOutEvent());
	        	 System.out.println("Logout");
	         }
	     });
	     
	     menuBar.setVisible(true);
	}




	private void addNavigatorView(String viewName,Class<? extends View> viewClass, Button menuButton) {
        nav.addView(viewName, viewClass);
        menuButton.addClickListener(event -> doNavigate(viewName));
        menuButton.setData(viewClass.getName());
    }
	
	
	private void doNavigate(String viewName) {
		UI.getCurrent().getNavigator().navigateTo(viewName);
		
		
	}


	 private Client getCurrentUser() {
		 	Client c = (Client) VaadinSession.getCurrent().getAttribute(Client.class.getName());
		 	System.out.println("Current User " + c.getClientName());
	        return c;
	       
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
