package com.spheres.agiletrack.view;

import com.ejt.vaadin.loginform.DefaultVerticalLoginForm;
import com.ejt.vaadin.loginform.LoginForm.LoginEvent;
import com.ejt.vaadin.loginform.LoginForm.LoginListener;
import com.spheres.agiletrack.view.forms.authentication.Login;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")

public class MainView extends VerticalLayout {
	protected CssLayout header_bar;
	protected NativeButton user_menu;
	protected Label user_name_label;
	protected TextField search_field;
	protected HorizontalLayout main_area;
	protected CssLayout side_bar;
	protected NativeButton mnuDashboard;
	protected NativeButton mnuBtn;
	protected NativeButton menuButton2;
	protected NativeButton menuButton4;
	protected NativeButton menuButton5;
	protected NativeButton menuButton6;
	protected NativeButton menuButton7;
	protected NativeButton menuButton8;
	protected Panel scroll_panel;

	public MainView() {
		Design.read(this);
	}
}
