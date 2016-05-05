package com.spheres.agiletrack.dummy;

import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;

public abstract class DummyDataGenerator {

	public static Color[] chartColors = new Color[] {
            new SolidColor("#3090F0"), new SolidColor("#18DDBB"),
            new SolidColor("#98DF58"), new SolidColor("#F9DD51"),
            new SolidColor("#F09042"), new SolidColor("#EC6464") };
	
	 public static int[] randomSparklineValues(int howMany, int min, int max) {
	        int[] values = new int[howMany];

	        for (int i = 0; i < howMany; i++) {
	            values[i] = (int) (min + (Math.random() * (max - min)));
	        }

	        return values;
	};
	
}
