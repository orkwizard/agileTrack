package com.spheres.agiletrack.core.server.commands;

public class LocationRequest extends Command {

	
	/*
	 * 
	 * 05 - Location request
		This command is sent by the server to request the unit's location.
		
		This command has the following fields:
		
		Part name	Length (characters)	Description
		Max. time to reply (optional)	0-4	Maximum number of seconds to wait for a GPS fix.
		If this parameter is ommited, the default value of Maximum time for first fix (parameter 0090) is used.
		Upon reception of this command, the unit will transmit the Confirmation message, then turn on the GPS, and keep it on until a valid location is found, or until the defined time is exceeded.
		
		Possible scenarios
		In case of GPS failure, the unit reply with error code 08 (no GPS communication).
		If the unit never had a GPS location, for example, if the GPS is installed in a shielded compartment, the unit will reply with error code of 07 (GPS location not available).
		If a location was received, the unit will send the Event report message with event code 01 (on-demand location).
		If the GPS is working, but failed to achieve an updated location, the unit will send the last known location as Event report message with event code 01 (on-demand location).
		Examples
		The following is a sample location request sequence:
		
		Server: $SRV0004D2,05,71*5A - Location request, default time limit
		Unit: $SLU0004D2,02,17,71,01*71
		The unit attempts to find a valid location
		Unit: $SLU0004D2,06,18,160530183447,01,160530183447,+2540.0043,-10023.9453,002.3,180,012345,12345,12345,12.200,03.600,0,0*66
		Another example, for a unit with no valid location:
		
		Server: $SRV0004D2,05,72,1*B8 - Location request, limited to 1 second
		Unit: $SLU0004D2,02,19,72,01*74
		Unit: $SLU0004D2,02,20,72,07*72 - No valid location

	 */
	
	
	
	
	private Integer max_time_reply;
	
	
	
	
	@Override
	public String toString() {
		return "LocationRequest [max_time_reply=" + max_time_reply + "]";
	}




	public Integer getMax_time_reply() {
		return max_time_reply;
	}




	public void setMax_time_reply(Integer max_time_reply) {
		this.max_time_reply = max_time_reply;
	}

	public void set_Max_time_reply(String max){
		try{
			this.max_time_reply = Integer.parseInt(max);
		}catch(NumberFormatException nf){
			this.max_time_reply = new Integer(150);
		}
	}



	public LocationRequest(String c, String d, double v) {
		super(c, d, v);
		// TODO Auto-generated constructor stub
	}

}
