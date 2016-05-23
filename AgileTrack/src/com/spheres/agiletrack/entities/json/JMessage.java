package com.spheres.agiletrack.entities.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spheres.agiletrack.entities.Data;
import com.spheres.agiletrack.entities.Message;

public class JMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private transient DateTime date; 
	private String line;
	private transient String instructions;
	private transient String checksum;
	private transient int index_checksum;
	private List<Data> data=new ArrayList<Data>();
	private transient boolean valid=false;
	
	public JMessage(String src){
		clean(src);
		buildMessage();
	}
	
	public boolean isValid(){
		return valid;
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
		StringTokenizer tokenizer;
		StringTokenizer tokens = new StringTokenizer(line, ",");
		
		
		if(validMessage(tokens)){
			tokenizer = new  StringTokenizer(instructions, ",");
			setDate(constructDate(tokenizer.nextToken(),tokenizer.nextToken()));
			String atoken = tokenizer.nextToken();
			setProtocolHeader(atoken);
			setMessageHeader(atoken);
			setUnitId(atoken);
			setCommand(Integer.parseInt(tokenizer.nextToken()));
			setReference(Integer.parseInt(tokenizer.nextToken()));
			while(tokenizer.hasMoreTokens())
				buildData(tokenizer.nextToken());
			checksum(checksum.replace('*', ' ').trim());
			valid = true;
		}else{
			System.out.println("Error: Message not valid !! : "+ line.toString());
			valid = false;
		}
		
	}
	
	private boolean validMessage(StringTokenizer t) {
		// TODO Auto-generated method stub
		//check for *
		//check for minimal tokens
		index_checksum = line.indexOf("*");
		if(index_checksum>0 && t.countTokens()>3){
			instructions = line.substring(0,index_checksum);
			checksum = line.substring(index_checksum);
			return true;
		}
		return false;
	}

	private void checksum(String atoken) {
		// TODO Auto-generated method stub
		//This token has the checksum and one datafield
		byte abyte = (byte)Integer.parseInt(atoken, 16);
		setChecksum(abyte);
		
		
	}

	private void buildData(String token){
		Data aData = new Data();
		aData.setField(token);
		//aData.setMessage(this);
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
	
	
	public Message get(){
		Message m = new Message();
		m.setMessageHeader(this.getMessageHeader());
		m.setCommand(this.getCommand());
		m.setChecksum(this.getChecksum());
		m.setMessageId(this.getMessageId());
		m.setReference(this.getReference());
		m.setUnitId(this.getUnitId());
		return m;
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
		String json= gson.toJson(this);
		return json;
		
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = new DateTime();
	}

	@Override
	public void setUnitId(String unitId) {
		// TODO Auto-generated method stub
		String uid = unitId.substring(4);
		super.setUnitId(uid);
	}

	@Override
	public void setMessageHeader(String messageHeader) {
		// TODO Auto-generated method stub
		super.setMessageHeader(messageHeader.substring(1,4));
	}

	@Override
	public void setProtocolHeader(String protocolHeader) {
		// TODO Auto-generated method stub
		super.setProtocolHeader(protocolHeader.substring(0,1));
	}

}
