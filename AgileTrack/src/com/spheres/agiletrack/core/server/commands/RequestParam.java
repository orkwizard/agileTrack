package com.spheres.agiletrack.core.server.commands;

public class RequestParam extends Command {

	private String parameter_number;
	
	//Response (unit → server):
	private String parameter_value;
	
	/*
		Response (unit → server):
		Part name	Length (characters)	Description
		Parameter number	1-4	Decimal parameter number (1-9999)
		Parameter value	As needed	The value of the requested parameter
	*/
	
	
	@Override
	public String toString() {
		return "Request [parameter_number=" + parameter_number + ", parameter_value=" + parameter_value + "]";
	}




	public String getParameter_number() {
		return parameter_number;
	}




	public void setParameter_number(String parameter_number) {
		this.parameter_number = parameter_number;
	}




	public String getParameter_value() {
		return parameter_value;
	}




	public void setParameter_value(String parameter_value) {
		this.parameter_value = parameter_value;
	}




	public RequestParam(String c, String d, double v) {
		super(c, d, v);
		// TODO Auto-generated constructor stub
	}

}
