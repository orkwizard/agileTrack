package com.spheres.agiletrack.view.forms.authentication;

import com.ejt.vaadin.loginform.LoginForm;
import com.spheres.agiletrack.event.AgileEventBus;
import com.spheres.agiletrack.event.AgileEvent.UserLoginRequestedEvent;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

public class Login extends LoginForm{
	
	public Login(){
		super();
		setSizeFull();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String Persistence_UNIT ="Agile";

	@Override
    protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
		
		Component loginForm = buildLoginForm();
		
		HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setSizeUndefined();
        layout.setSpacing(true);
        layout.addStyleName("login-panel");
        layout.addComponent(loginForm);
        layout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
        return layout;
    }

	private Component buildLoginForm() {
		// TODO Auto-generated method stub
		final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");
        //loginPanel.addComponent(new ThemeResource(
        //        "img/agile.jpg"));
        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Recordarme", true));
        
        
        return loginPanel;

	}

	private Component buildFields() {
		HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        final TextField userNameField = new TextField("Usuario");
        userNameField.setIcon(FontAwesome.USER);
        userNameField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final PasswordField passwordField = new PasswordField("Password");
        passwordField.setIcon(FontAwesome.LOCK);
        passwordField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button loginButton = new Button("Log In");
        loginButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        loginButton.setClickShortcut(KeyCode.ENTER);
        loginButton.focus();
        fields.addComponents(userNameField, passwordField, loginButton);
        fields.setComponentAlignment(loginButton, Alignment.BOTTOM_LEFT);
        
        loginButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				AgileEventBus.post(new UserLoginRequestedEvent(userNameField.getValue(), passwordField.getValue()));
				
			}
		});
        return fields;
	}

	
	private Component buildLabels() {
		CssLayout labels = new CssLayout();
        labels.addStyleName("labels");
        Label welcome = new Label("Bienvenido a AgileTrack");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);
        return labels;
	}	
}
