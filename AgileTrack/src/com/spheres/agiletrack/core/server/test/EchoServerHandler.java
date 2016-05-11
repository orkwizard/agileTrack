package com.spheres.agiletrack.core.server.test;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class EchoServerHandler extends SimpleChannelHandler { 
 
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) { 
         ChannelBuffer  buf = (ChannelBuffer) e.getMessage();
         System.out.println("Message :" + e.getMessage().toString());
            while(buf.readable()) {
            	//System.out.println(buf.readableBytes());
                System.out.println((char) buf.readByte());
                System.out.flush();
            }
    }
 
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) { 
        e.getCause().printStackTrace();
         
        Channel ch = e.getChannel();
        ch.close();
    }
}
