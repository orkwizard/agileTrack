package com.spheres.agiletrack.app;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class DashboardImp extends Dashboard implements View{

	public static final String VIEW_NAME = "dashboard";
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public DashboardImp(){
		super();
		addChart();
		
		
		
	}
	
	private void addChart(){
		Chart chart = new Chart(ChartType.BAR);
		chart.setWidth("365px");
		chart.setHeight("250px");

		// Modify the default configuration a bit
		Configuration conf = chart.getConfiguration();
		conf.setTitle("Planets");
		conf.setSubTitle("The bigger they are the harder they pull");
		conf.getLegend().setEnabled(false); // Disable legend

		// The data
		ListSeries series = new ListSeries("Diameter");
		series.setData(4900,  12100,  12800,
		               6800,  143000, 125000,
		               51100, 49500);
		conf.addSeries(series);

		// Set the category labels on the axis correspondingly
		XAxis xaxis = new XAxis();
		xaxis.setCategories("Mercury", "Venus",   "Earth",
		                    "Mars",    "Jupiter", "Saturn",
		                    "Uranus",  "Neptune");
		xaxis.setTitle("Planet");
		conf.addxAxis(xaxis);

		// Set the Y axis title
		YAxis yaxis = new YAxis();
		yaxis.setTitle("Diameter");
		yaxis.getLabels().setFormatter(
		  "function() {return Math.floor(this.value/1000) + \' Mm\';}");
		yaxis.getLabels().setStep(2);
		conf.addyAxis(yaxis);
		
		dashboardpane.addComponent(chart);
		

	}

}
