package com.spheres.agiletrack.entities.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gwt.json.client.JSONObject;
import com.spheres.agiletrack.entities.Data;

public class Message extends com.spheres.agiletrack.entities.Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateTime date; 
	private String line;
	private StringTokenizer tokenizer;
	private List<Data> data=new ArrayList<Data>();
	private Gson gson;
	
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
		 * No me gusta esta solución buscar una mas elegante
		 * 
		 */
		gson = new GsonBuilder().setPrettyPrinting().create();	
		int size = tokenizer.countTokens();
		if(size>3){
			setDate(constructDate(tokenizer.nextToken(),tokenizer.nextToken()));
			String atoken = tokenizer.nextToken();
			setProtocolHeader(atoken.substring(0,1));
			setMessageHeader(atoken.substring(1,4));
			setUnitId(atoken);
			setCommand(Integer.parseInt(tokenizer.nextToken()));
			setReference(Integer.parseInt(tokenizer.nextToken()));
			//Check data fields
			while(!(atoken=tokenizer.nextToken()).contains("*"))
				buildData(atoken);
			checksum(atoken);
			
			//last one with data and checksum
			System.out.println(atoken);
			
			
			
		}else
			//Raise Exception: Tokens not valids
			System.out.println("Error: Tokens not Validos");
	}
	
	private void checksum(String atoken) {
		// TODO Auto-generated method stub
		//This token has the checksum and one datafield
		int index = atoken.indexOf("*");
		String data = atoken.substring(0,index);
		String checksum = atoken.substring((index+1));
		buildData(data);
		byte abyte = (byte)Integer.parseInt(checksum, 16);
		setChecksum(abyte);
		
		
	}

	private void buildData(String token){
		Data aData = new Data();
		aData.setField(token);
		aData.setMessage(this);
		data.add(aData);
	}
	
	
	private DateTime constructDate(String day,String time) {
		// TODO Auto-generated method stub
		//POR HACER:
		
		return new DateTime();
	}

	private void clean(String src){
		line = src.replaceAll(" ",",");
		line = line.replaceAll("(\\r|\\n)","");
		line = line.replaceAll("\\t",",");
	}
	
	public String toJson(){
		
		return gson.toJson(this);
	}
	
	public Message get(){
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("Message: {id:" + getMessageId() +" Protocol Header: "+ getProtocolHeader()  +" Message Header: " +getMessageHeader() + ",unit_id:"+ getUnitId()+" Command :"+ getCommand() +" Reference:"+getReference() + " Data:[");
		Iterator<Data> iterator = data.iterator();
		
		while(iterator.hasNext())
			str.append(iterator.next().getField().toString()+",");
		
		str.append("] Checksum (HEX) : " + Integer.toHexString(getChecksum()).toUpperCase());
		
		return str.toString();
	}
	
	public String getJSON(){
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		
		try {
			 json = mapper.writeValueAsString(this.get());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
		
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
		String uid = unitId.substring(4);
		super.setUnitId(uid);
	}

}
