package com.spheres.agiletrack.view;

import javax.servlet.annotation.WebServlet;

import com.ejt.vaadin.loginform.DefaultVerticalLoginForm;
import com.ejt.vaadin.loginform.LoginForm.LoginEvent;
import com.ejt.vaadin.loginform.LoginForm.LoginListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("agiletrack")
@Widgetset("com.spheres.agiletrack.view.widgetset.AgiletrackWidgetset")

public class AgiletrackUI extends UI {

	Navigator navigator;
	protected static final String MAINVIEW = "main";
	DefaultVerticalLoginForm loginForm = new DefaultVerticalLoginForm();
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AgiletrackUI.class)
	
	
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final MainView main = new MainView();
		loginForm.addLoginListener(new LoginListener() {
			
			@Override
			public void onLogin(LoginEvent event) {
				// TODO Auto-generated method stub
				System.err.println(
		                "Logged in with user name " + event.getUserName() +
		                        " and password of length " + event.getPassword().length());
				setContent(main);
			}
		});
		
		loginForm.clear();
		setContent(loginForm);
		
		/*final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);
		*/
		
		//getPage().setTitle("AgileTrack ...");
		//navigator = new Navigator(this,this);
		
		//navigator.addView("", new MainView());
		
		
		//final MainView app = new MainView();
		//setContent(app);
		
		
	}

}