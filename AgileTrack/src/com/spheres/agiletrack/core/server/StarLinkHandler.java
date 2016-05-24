package com.spheres.agiletrack.core.server;

import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.WriteCompletionEvent;

import com.spheres.agiletrack.elasticsearch.ElasticClient;
import com.spheres.agiletrack.entities.json.JMessage;

public class StarLinkHandler extends SimpleChannelUpstreamHandler {

	private ElasticClient client = new ElasticClient("10.194.25.220",9300,25);
	private double server_reference;
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		ChannelBuffer  buf = (ChannelBuffer) e.getMessage();
		String str="";
	    while(buf.readable()) {
	        str+=(char)buf.readByte();
	    }
	    System.out.flush();
	    String cmd = StringUtils.chomp(str);
	    
	    
	    
	    if(cmd.equalsIgnoreCase("exit")){
	    	ctx.getChannel().close();
	    	client.CLOSING_CLIENT=true;
	    }else{
		    JMessage m = Decoder.encode(str);
		    if(m!=null)
		    	client.addMessage(m);
		    	client.writeMessages();
		    	Channel ch =  e.getChannel();
		    	ch.write(e.getMessage());
		    	System.out.println(ch.getRemoteAddress().toString());
			
	    }
	    buf.clear();
	    
	    
	    super.messageReceived(ctx, e);
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelOpen(ctx, e);
	}

	@Override
	public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelBound(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelConnected(ctx, e);
	}

	@Override
	public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.writeComplete(ctx, e);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		// TODO Auto-generated method stub
		e.getCause().printStackTrace();
		super.exceptionCaught(ctx, e);
	}

}
