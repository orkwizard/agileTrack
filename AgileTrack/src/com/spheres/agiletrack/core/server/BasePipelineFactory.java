package com.spheres.agiletrack.core.server;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;

public class BasePipelineFactory implements ChannelPipelineFactory {
	
	private final AgileTrackServer server;
	private final int resetDelay;
	private StarLinkMessageHandler starlink;

	public BasePipelineFactory(AgileTrackServer agileTrackServer, String protocol) {
		// TODO Auto-generated constructor stub
		server = agileTrackServer;
		resetDelay = Context.getConfig().getInteger(protocol + ".resetDelay", 0);
		
		starlink = new StarLinkMessageHandler(server);
		//if(Context.getConfig().get)
		
		
		
		
		
	}

	private static final class OpenChannelHandler extends SimpleChannelHandler {

        private final AgileTrackServer server;

        private OpenChannelHandler(AgileTrackServer server) {
            this.server = server;
        }
	
        @Override
        public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
            server.getChannelGroup().add(e.getChannel());
        }
	}
	
	
	private static class StarLinkMessageHandler extends SimpleChannelHandler{
		 private final AgileTrackServer server;

	        private StarLinkMessageHandler(AgileTrackServer server) {
	            this.server = server;
	        }
		
	        @Override
	        public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
	            server.getChannelGroup().add(e.getChannel());
	        }
		
	}
	
	
	
	@Override
	public ChannelPipeline getPipeline() throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipeline = Channels.pipeline();
		pipeline.addLast("starlink", starlink);
		addSpecificHandlers(pipeline);
		
		return pipeline;
	}

	protected void addSpecificHandlers(ChannelPipeline pipeline) {
		// TODO Auto-generated method stub
		
	}

}
