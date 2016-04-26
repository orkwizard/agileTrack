package com.spheres.agiletrack.view.forms.authentication;

import com.ejt.vaadin.loginform.*;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class Login extends LoginForm {

	@Override
    protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);

        layout.addComponent(userNameField);
        layout.addComponent(passwordField);
        layout.addComponent(loginButton);
        layout.setComponentAlignment(loginButton, Alignment.BOTTOM_LEFT);
        return layout;
    }

    // You can also override this method to handle the login directly, instead of using the event mechanism
    @Override
    protected void login(String userName, String password) {
        System.err.println(
            "Logged in with user name " + userName +
            " and password of length " + password.length()
        );
    }
	
}
