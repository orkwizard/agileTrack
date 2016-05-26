package com.spheres.agiletrack.core.server;

import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.WriteCompletionEvent;

import com.spheres.agiletrack.elasticsearch.ElasticClient;
import com.spheres.agiletrack.entities.json.JMessage;

public class StarLinkHandler extends SimpleChannelHandler {

	private ElasticClient client = new ElasticClient("10.194.25.220",9300,25);
	private double server_reference;
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)throws  Exception{
		String str = e.getMessage().toString();
	    String cmd = StringUtils.chomp(str);
	    if(cmd.equalsIgnoreCase("exit"))
	    	ctx.getChannel().disconnect();
	    
	    JMessage m = Decoder.encode(str);
	    if(m!=null)
	    	client.writeMessage(m);
	    
	    StarLinkCompiler.compile(m,ctx);
	    super.messageReceived(ctx,e);
	}

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.writeRequested(ctx, e);
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
