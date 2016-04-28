package com.spheres.agiletrack.view;

import javax.servlet.annotation.WebServlet;

import com.ejt.vaadin.loginform.LoginForm.LoginEvent;
import com.ejt.vaadin.loginform.LoginForm.LoginListener;
import com.spheres.agiletrack.view.forms.authentication.Login;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("agiletrack")
@Widgetset("com.spheres.agiletrack.view.widgetset.AgiletrackWidgetset")

public class AgiletrackUI extends UI {
	protected static final String MAINVIEW = "main";
	Login loginForm = new Login();
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AgiletrackUI.class)
	
	
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("AgileTrack");
		final MainViewImpl main = new MainViewImpl();
		loginForm.clear();
		setContent(loginForm);
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
	}

}