package com.spheres.agiletrack.core.server.commands;

import java.util.HashMap;
import java.util.Map;

public class Confirmation {

	private int original_reference;
	private int result_code;
	private Map<String,String> codes;
	
	
	
	public int getOriginal_reference() {
		return original_reference;
	}



	public void setOriginal_reference(int original_reference) {
		this.original_reference = original_reference;
	}



	public Map<String, String> getCodes() {
		return codes;
	}



	


	public int getResult_code() {
		return result_code;
	}



	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}



	public Confirmation(){
		codes = new HashMap<String,String>();
		codes.put("01","Command is acknowledged	");
		codes.put("02","Unsupported command	");
		codes.put("03","Wrong number of parameters");
		codes.put("04","One of the parameters is invalid");
		codes.put("05","Command received with the wrong unit id	");
		codes.put("06","Command received with the wrong check-sum	");
		codes.put("07","GPS Location not available	");
		codes.put("08","No communication with GPS	");
		codes.put("09","Command too long	");
		codes.put("10","Not enough room for points in geo-zone	");
		codes.put("11","Invalid alarm command	");
		codes.put("12","Error while trying to communicate with alarm	");
		codes.put("13","Acknowledgment for setting parameter	");
		codes.put("14","Invalid value when setting parameter	");
		codes.put("15","No communication with Canalog	");
		codes.put("16","Unable to transmit server SMS (unit busy)	");
		codes.put("17","Unable to transmit server SMS (failed)	");
		codes.put("18","Unable to send data to external device	");
		codes.put("19","Unable to communicate with iButton	");
		codes.put("20","Multiple parameters updated	");
		codes.put("21","List of allowed drivers was updated	");
		codes.put("22","Firmware update is busy	");
		codes.put("97","Modem firmware update complete	");
		codes.put("98","Unit unlock is needed	");
		codes.put("99","Other error	");
	}
	
	
	
	
}
