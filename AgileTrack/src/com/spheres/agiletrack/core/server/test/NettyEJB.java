package com.spheres.agiletrack.core.server.test;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;

import com.spheres.agiletrack.core.server.AgileTrackServer;


public class NettyEJB extends AgileTrackServer {
	
	
	public static void main(String[] args){
		System.out.println("Init Server");
	
		NettyEJB server = new NettyEJB();
	
		
		
		
		
		try {
			server.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	protected void addSpecificHandlers(ChannelPipeline pipeline) {
		addSpecificHandlers((ChannelPipeline) new EchoServerHandler());
		
	}
}
