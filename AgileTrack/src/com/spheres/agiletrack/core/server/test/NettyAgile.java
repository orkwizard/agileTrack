package com.spheres.agiletrack.core.server.test;

import org.jboss.netty.channel.ChannelPipeline;

import com.spheres.agiletrack.core.server.AgileTrackServer;
import com.spheres.agiletrack.core.server.StarLinkHandler;


public class NettyAgile extends AgileTrackServer  {
	
	
	public static void main(String[] args){
       System.out.println("Starting server...");

       NettyAgile server = new NettyAgile();
		try {
			server.startServer();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void addSpecificHandlers(ChannelPipeline pipeline) {
		addSpecificHandlers((ChannelPipeline) new StarLinkHandler());
	}
}
