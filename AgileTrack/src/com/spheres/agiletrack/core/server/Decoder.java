package com.spheres.agiletrack.core.server;

import com.google.gson.Gson;
import com.spheres.agiletrack.entities.json.JMessage;


public class Decoder {
	private static JMessage message=null;
	
	public static JMessage encode(String line){
		message = new JMessage(line);
		return message;
		
	}
}
