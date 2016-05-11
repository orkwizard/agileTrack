package com.spheres.agiletrack.core.server.test;

import java.nio.CharBuffer;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.mysql.fabric.xmlrpc.base.Array;

public class EchoServerHandler extends SimpleChannelHandler { 
 
	 private final AtomicLong transferredBytes = new AtomicLong();
	 
	
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) { 
         ChannelBuffer  buf = (ChannelBuffer) e.getMessage();
         byte[] chars = buf.array();
         System.out.println("Chars :" + chars.toString());
         
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
