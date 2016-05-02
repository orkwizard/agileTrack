package com.spheres.agiletrack.view;

import javax.servlet.annotation.WebServlet;

import com.google.common.eventbus.Subscribe;
import com.spheres.agiletrack.data.JPADataProvider;
import com.spheres.agiletrack.domain.DataProvider;
import com.spheres.agiletrack.entities.Client;
import com.spheres.agiletrack.event.AgileEvent.UserLoginRequestedEvent;
import com.spheres.agiletrack.event.AgileEventBus;
import com.spheres.agiletrack.view.forms.authentication.Login;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;


@SuppressWarnings("serial")
@Theme("agiletrack")
@Widgetset("com.spheres.agiletrack.view.widgetset.AgiletrackWidgetset")

public class AgiletrackUI extends UI {
	protected static final String MAINVIEW = "main";
	//private final static String Persistence_UNIT ="Agile";
	private final AgileEventBus agileEventbus = new AgileEventBus();
	private final DataProvider dataProvider = new JPADataProvider();
	
	Login loginForm;
	MainViewImpl main;
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AgiletrackUI.class)
	
	
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("AgileTrack");
		
		AgileEventBus.register(this);
	    Responsive.makeResponsive(this);
	    addStyleName(ValoTheme.UI_WITH_MENU);
		loginForm = new Login();
		loginForm.clear();
		setContent(loginForm);
	}

	 @Subscribe
	    public void userLoginRequested(final UserLoginRequestedEvent event) {
	        Client user = getDataProvider().authenticate(event.getUserName(),
	                event.getPassword());
	        
	        if(user!=null){
	        	VaadinSession.getCurrent().setAttribute(Client.class.getName(), user);
	        	startSession();
	        	
	        }
	        else{
	        	raiseError(new Notification("Usuario / Password Erroneo",Notification.Type.HUMANIZED_MESSAGE));
	        	
	        	
	        	
	        }
	        //FALTA AGREGAR CONTENIDO!!!!
	        
	        //updateContent();
	    }
	
	 private void raiseError(Notification notification) {
		// TODO Auto-generated method stub
		notification.show(Page.getCurrent());
	}

	private void startSession(){
		 main = new MainViewImpl();
		 setContent(main);
	 }
	 
	 public static DataProvider getDataProvider() {
	        return ((AgiletrackUI) getCurrent()).dataProvider;
	    }

	public static AgileEventBus getAgileEventbus() {
		return ((AgiletrackUI) getCurrent()).agileEventbus;
	}

}