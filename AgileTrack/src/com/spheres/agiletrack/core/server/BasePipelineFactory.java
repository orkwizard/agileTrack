package com.spheres.agiletrack.core.server;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;

public class BasePipelineFactory implements ChannelPipelineFactory {
	
	private final AgileTrackServer server;
	private final int resetDelay;
	

	public BasePipelineFactory(AgileTrackServer agileTrackServer, String protocol) {
		// TODO Auto-generated constructor stub
		server = agileTrackServer;
		resetDelay = Context.getConfig().getInteger(protocol + ".resetDelay", 0);
	}

	
	@Override
	public ChannelPipeline getPipeline() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	protected void addSpecificHandlers(ChannelPipeline pipeline) {
		// TODO Auto-generated method stub
		
	}

}
