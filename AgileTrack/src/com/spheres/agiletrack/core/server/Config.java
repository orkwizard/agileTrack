package com.spheres.agiletrack.core.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	 private final Properties properties = new Properties();

	    public void load(String file) throws IOException {
	        try (InputStream inputStream = new FileInputStream(file)) {
	            properties.loadFromXML(inputStream);
	        }
	    }

	    public boolean hasKey(String key) {
	        return properties.containsKey(key);
	    }

	    public boolean getBoolean(String key) {
	        return Boolean.parseBoolean(properties.getProperty(key));
	    }

	    public int getInteger(String key) {
	        return getInteger(key, 0);
	    }

	    public int getInteger(String key, int defaultValue) {
	        if (properties.containsKey(key)) {
	            return Integer.parseInt(properties.getProperty(key));
	        } else {
	            return defaultValue;
	        }
	    }

	    public long getLong(String key) {
	        return getLong(key, 0);
	    }

	    public long getLong(String key, long defaultValue) {
	        if (properties.containsKey(key)) {
	            return Long.parseLong(properties.getProperty(key));
	        } else {
	            return defaultValue;
	        }
	    }

	    public String getString(String key) {
	        return properties.getProperty(key);
	    }

	    public String getString(String key, String defaultValue) {
	        if (properties.containsKey(key)) {
	            return properties.getProperty(key);
	        } else {
	            return defaultValue;
	        }
	    }
}
