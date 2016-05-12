package com.spheres.agiletrack.core.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spheres.agiletrack.entities.Message;

public class Decoder {
	private static Message message=null;
	
	public static Message decode(String line){
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(line);
		System.out.println(json.toString());
		return message;
		
	}
}
