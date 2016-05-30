package com.spheres.agiletrack.core.server.commands;

public class SetParam extends Command {

	private String param_number;
	private String new_value;
	
	//In response, the unit will send a Confirmation message with a result code of 01 (acknowledgment) or 04 (one of the parameters is invalid).
	
	private int confirmation_message; 
	
	/*
	 * This command is sent to the StarLink unit in order to change the value of a numbered parameter.
	
	In response, the unit will send a Confirmation message with a result code of 01 (acknowledgment) or 04 (one of the parameters is invalid).
	
	This command has the following fields:
	
	Part name	Length (characters)	Description
	Parameter number	1-4	The number of the parameter we wish to set (1-9999)
	New value	As needed	The new value we wish to set to the parameter
	Examples
	The following sequence is a command and reply for changing the Primary server IP (parameter 0049) parameter:
	
	Server: $SRV0004D2,04,12,0049,agiletrack.spheres.com.mx*38
	Unit: $SLU0004D2,02,27,12,13,0049*69
	The unit acknowledged that the server IP address was changed.
	
	The following sequence is a command and reply for changing a non-existent parameter for the same unit:
	
	Server: $SRV0004D2,04,13,0000,value*8A
	Unit: $SLU0004D2,02,28,13,14,0000*5F
	The unit replied with a result code of 14 (bad parameter value).
	
	*/
		
	
	public int getConfirmation_message() {
		return confirmation_message;
	}



	public void setConfirmation_message(int confirmation_message) {
		this.confirmation_message = confirmation_message;
	}



	@Override
	public String toString() {
		return "SetParam [param_number=" + param_number + ", new_value=" + new_value + ", confirmation_message="
				+ confirmation_message + "]";
	}



	public String getParam_number() {
		return param_number;
	}



	public void setParam_number(String param_number) {
		this.param_number = param_number;
	}



	public String getNew_value() {
		return new_value;
	}



	public void setNew_value(String new_value) {
		this.new_value = new_value;
	}



	public SetParam(String c, String d, double v) {
		super(c, d, v);
		// TODO Auto-generated constructor stub
	}

}
