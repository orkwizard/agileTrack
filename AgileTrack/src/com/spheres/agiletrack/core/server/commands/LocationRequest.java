package com.spheres.agiletrack.core.server.commands;

public class LocationRequest extends Command {

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
