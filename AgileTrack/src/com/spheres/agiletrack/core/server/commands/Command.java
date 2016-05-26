package com.spheres.agiletrack.core.server.commands;

import java.util.ArrayList;
import java.util.HashMap;

public class Command {

	private String code;
	private String description;
	private double version;
	
	
	public Command(String c,String d,double v){
		code = c;
		description = d;
		version = v;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getVersion() {
		return version;
	}


	public void setVersion(double version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Command [code=" + code + ", description=" + description + ", version=" + version + "]";
	}
	
	
}
