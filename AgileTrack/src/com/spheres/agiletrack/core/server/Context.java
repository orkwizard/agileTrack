package com.spheres.agiletrack.core.server;


public final class Context {

	 private Context() {
	 }

	    private static Config config;

	    public static Config getConfig() {
	        return config;
	    }

	    private static boolean loggerEnabled;

	    public static boolean isLoggerEnabled() {
	        return loggerEnabled;
	    }
}
