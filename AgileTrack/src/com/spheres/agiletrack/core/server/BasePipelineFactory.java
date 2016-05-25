package com.spheres.agiletrack.core.server;


import java.nio.charset.Charset;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.util.CharsetUtil;

public class BasePipelineFactory implements ChannelPipelineFactory {

	
	public ChannelPipeline getPipeline() throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipeline = Channels.pipeline();
		//Decoders
		 int maxFrameLength = 1024;
	    pipeline.addLast("framer", new DelimiterBasedFrameDecoder(maxFrameLength, Delimiters.lineDelimiter()));
		pipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8) );	
		pipeline.addLast("stringEncoder",new StringEncoder(CharsetUtil.UTF_8) );
		pipeline.addLast("starlink",new StarLinkHandler());
		return pipeline;
	}
}


/*	
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

}*/
