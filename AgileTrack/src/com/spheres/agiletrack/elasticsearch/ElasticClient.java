package com.spheres.agiletrack.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
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
	
	private ArrayList<JMessage> messages;
	
	@SuppressWarnings("resource")
	
	public ElasticClient(String h,int p,Settings s){
		host = h;
		port = p;
		messages = new ArrayList<JMessage>();
		settings = Settings.settingsBuilder().put("cluster.name","Logstash_Sunset").build();
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

	
	public void writeMessages(){
		Iterator<JMessage> i = messages.iterator();
		BulkRequestBuilder bulk = es_client.prepareBulk();
			while(i.hasNext()){
				IndexResponse index  = es_client.prepareIndex("starlink", "Message").setSource(i.next().getJSON()).get();
				System.out.println("INDEXED as" + index.getId());
			}
			
	}
	
	public Client getEs_client() {
		return es_client;
	}

	public static void main(String[] args){
		ElasticClient e = new ElasticClient("10.194.25.220",9300,null);
		
	}
	
}
