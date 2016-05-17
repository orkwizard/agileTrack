package com.spheres.agiletrack.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ElasticClient {

	private Settings settings;
	private Client es_client;
	private String host;
	private int port;
	
	@SuppressWarnings("resource")
	
	public ElasticClient(String h,int p,Settings s){
		host = h;
		port = p;
		//settings = ImmutableSettings.settingsBuilder();
		es_client = new TransportClient()
				.addTransportAddresses(new InetSocketTransportAddress(host,port));
	}
	
	
	
	
	public void close(){
		es_client.close();
	}
	
	
}
