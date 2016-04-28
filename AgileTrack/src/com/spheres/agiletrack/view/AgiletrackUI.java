package com.spheres.agiletrack.view;

import java.util.Iterator;

import javax.servlet.annotation.WebServlet;

import com.ejt.vaadin.loginform.LoginForm.LoginEvent;
import com.ejt.vaadin.loginform.LoginForm.LoginListener;
import com.spheres.agiletrack.entities.Client;
import com.spheres.agiletrack.view.forms.authentication.Login;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Compare;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@SuppressWarnings("serial")
@Theme("agiletrack")
@Widgetset("com.spheres.agiletrack.view.widgetset.AgiletrackWidgetset")

public class AgiletrackUI extends UI {
	protected static final String MAINVIEW = "main";
	private final static String Persistence_UNIT ="Agile";
	
	Login loginForm = new Login();
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AgiletrackUI.class)
	
	
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("AgileTrack");
		JPAContainer<Client> clientes = JPAContainerFactory.makeReadOnly(Client.class,Persistence_UNIT);
		final MainViewImpl main = new MainViewImpl();
		loginForm.clear();
		setContent(loginForm);
		
		
		loginForm.addLoginListener(new LoginListener() {
			
			@Override
			public void onLogin(LoginEvent event) {
				// TODO Auto-generated method stub
				clientes.removeAllContainerFilters();
				Filter filter = new Compare.Equal("clientLogin",event.getUserName());
				Filter filter2 = new Compare.Equal("clientPassword", event.getPassword().trim());
				clientes.addContainerFilter(filter);
				clientes.addContainerFilter(filter2);
				if(clientes.size()>0){
					String  itemId = clientes.getItemIds().iterator().next().toString();
					System.out.println(itemId);
					String name = clientes.getItem(Integer.parseInt(itemId)).getEntity().getClientName();
					main.user_name_label.setValue(name);
					setContent(main);
				}
				else{
					System.out.println("Error Wrong Password");
					//loginForm.setErrorHandler(getErrorHandler());
				}
				
			}
		});
	}

}