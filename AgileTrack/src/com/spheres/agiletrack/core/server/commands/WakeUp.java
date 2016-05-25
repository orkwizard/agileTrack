package com.spheres.agiletrack.core.server.commands;

public class WakeUp {
	//A string in the format of "N.NN" containing the unit's firmware version
	private String unit_version; 
	//A string in the format of "N.NN" containing the unit's protocol version
	private String protocol_version;
	
	public String getUnit_version() {
		return unit_version;
	}
	public void setUnit_version(String unit_version) {
		this.unit_version = unit_version;
	}
	public String getProtocol_version() {
		return protocol_version;
	}
	public void setProtocol_version(String protocol_version) {
		this.protocol_version = protocol_version;
	}
	
	public WakeUp(String u,String p){
		unit_version = u;
		protocol_version = p;
	}
	
	@Override
	public String toString() {
		return "WakeUp [unit_version=" + unit_version + ", protocol_version=" + protocol_version + "]";
	}
	
	
	
	
}
