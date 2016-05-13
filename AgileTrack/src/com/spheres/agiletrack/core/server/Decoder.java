package com.spheres.agiletrack.core.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spheres.agiletrack.entities.json.Message;

public class Decoder {
	private static Message message=null;
	
	public static Message decode(String line){
		message = new Message(line);
		return message;
		
	}
}
