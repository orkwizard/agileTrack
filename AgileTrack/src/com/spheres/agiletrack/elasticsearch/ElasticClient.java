package com.spheres.agiletrack.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.spheres.agiletrack.entities.json.JMessage;

public class ElasticClient {
	
	private Settings settings;
	private Client es_client;
	private String host;
	private int port;
	private String index_name;
	private String type;
	private int buffer;
	
	private ArrayList<JMessage> messages;
	public boolean CLOSING_CLIENT = false;
	
	@SuppressWarnings("resource")
	
	public ElasticClient(String h,int p,int b){
		host = h;
		port = p;
		messages = new ArrayList<JMessage>();
		settings = Settings.settingsBuilder().put("cluster.name","Logstash_Sunset").build();
		buffer = b;
		try {
			es_client = new TransportClient.Builder().settings(settings).build()
					.addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(host),port));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMessage(JMessage m){
		messages.add(m);
	}
	
	public void close(){
		es_client.close();
	}

	public int size(){
		return messages.size();
	}
	
	public void writeMessages(){
		int size = messages.size();
		if(size>=buffer  || CLOSING_CLIENT){
			Iterator<JMessage> i = messages.iterator();
			BulkRequestBuilder bulk = es_client.prepareBulk();
				while(i.hasNext()){
					IndexRequestBuilder index  = es_client.prepareIndex("starlink", "Message").setSource(i.next().getJSON());
					bulk.add(index);
				}
			BulkResponse response = bulk.execute().actionGet();
			if(response.hasFailures())
				System.out.println(response.buildFailureMessage());
			else{
					//Implementar ROLL BACK de todo
				System.out.println("Indexed:" + size + " records in:"+ response.getTookInMillis() +" miliseconds");
			}
			messages.clear();
		}else
			System.out.println("Waiting buffer to get bigger ......");
		
		
		if(CLOSING_CLIENT){
			this.close();
			System.out.println("Elastic closed!");
		}
	}
	
	public Client getEs_client() {
		return es_client;
	}

	public static void main(String[] args){
		ElasticClient e = new ElasticClient("10.194.25.220",9300,25);
		
	}
	
}
