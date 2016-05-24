package com.spheres.agiletrack.app;

import com.spheres.agiletrack.dummy.DummyDataGenerator;
import com.spheres.agiletrack.dummy.SparklineChart;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;

public class DashboardImp extends Dashboard implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045732231532159610L;
	public static final String VIEW_NAME = "dashboard";
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public DashboardImp(){
		super();
		buildSparklines();
		addChart();
		buildGoogleMap();
		
		
	}
	
	
	private void buildGoogleMap(){
		GoogleMap googleMap;
	    GoogleMapMarker kakolaMarker = new GoogleMapMarker(
	    		"DRAGGABLE: Kakolan vankila", new LatLon(21.135368, -86.764184),true, null);
	    GoogleMapInfoWindow kakolaInfoWindow = new GoogleMapInfoWindow(
	        "Kakola used to be a provincial prison.", kakolaMarker);
	    final String apiKey = "";
	    googleMap = new GoogleMap(null, null, null);
	    googleMap.setCenter(new LatLon(21.135368, -86.764184));
        googleMap.setZoom(10);
        googleMap.setSizeFull();
        kakolaMarker.setAnimationEnabled(false);
        googleMap.addMarker(kakolaMarker);
        googleMap.addMarker("DRAGGABLE: Royal Sunset", new LatLon(
        		21.135368, -86.764184), true, "VAADIN/1377279006_stadium.png");
        googleMap.addMarker("NOT DRAGGABLE: Sunset Lagoon", new LatLon(
        		21.135368, -86.764184), false, null);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);

        kakolaInfoWindow.setWidth("400px");
        kakolaInfoWindow.setHeight("500px");
	    //dashboardmaps.setExpandRatio(googleMap, 1.0f);
        dashboardmaps.addComponent(googleMap);
	    
	}
	
	
	 private void buildSparklines() {
	        
	        dashgraphics.addStyleName("sparks");
	        dashgraphics.setWidth("1142px");
	        Responsive.makeResponsive(dashgraphics);

	        SparklineChart s = new SparklineChart("Traffic", "K", "",
	                DummyDataGenerator.chartColors[0], 22, 20, 80);
	        dashgraphics.addComponent(s);

	        s = new SparklineChart("Revenue / Day", "M", "$",
	                DummyDataGenerator.chartColors[2], 8, 89, 150);
	        dashgraphics.addComponent(s);

	        s = new SparklineChart("Checkout Time", "s", "",
	                DummyDataGenerator.chartColors[3], 10, 30, 120);
	        dashgraphics.addComponent(s);

	        s = new SparklineChart(" Fill Rate", "%", "",
	                DummyDataGenerator.chartColors[5], 50, 34, 100);
	        dashgraphics.addComponent(s);
	        
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
