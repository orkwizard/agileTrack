package com.spheres.agiletrack.entities.json;

import java.util.StringTokenizer;

import org.joda.time.DateTime;

public class Message extends com.spheres.agiletrack.entities.Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateTime date; 
	private String line;
	private StringTokenizer tokenizer;
	
	public Message(String src){
		clean(src);
		tokenizer = new StringTokenizer(line, ",");
		System.out.println("Tokens: " + tokenizer.countTokens());
		buildMessage();
	}
	
	private void buildMessage(){
		/*
		 * El mensaje trae una cantidad de tokens variable,
		 * Solamente se controla los primeros que son fijos
		 * Los de datos son los que van despues
		 * 
		 */
		int size = tokenizer.countTokens();
		if(size>0){
			setDate(constructDate(tokenizer.nextToken(),tokenizer.nextToken()));
			setUnitId(tokenizer.nextToken());
			
			
		}else
			//Raise Exception: Tokens not valids
			System.out.println("Error: Tokens not Valids");
	}
	
	
	
	private DateTime constructDate(String day,String time) {
		// TODO Auto-generated method stub
		
		return null;
	}

	private void clean(String src){
		line = src.replaceAll(" ",",");
		line = line.replaceAll("(\\r|\\n)","");
		line = line.replaceAll("\\t",",");
	}
	
	public String toJson(){
		
		return null;
	}
	
	public Message get(){
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return line;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@Override
	public void setUnitId(String unitId) {
		// TODO Auto-generated method stub
		String uid = unitId.substring(3);
		super.setUnitId(unitId);
	}
	
	
	

}
